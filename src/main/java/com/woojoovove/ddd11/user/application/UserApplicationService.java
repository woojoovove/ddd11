package com.woojoovove.ddd11.user.application;

import com.woojoovove.ddd11.user.application.common.UserData;
import com.woojoovove.ddd11.user.application.delete.UserDeleteCommand;
import com.woojoovove.ddd11.user.application.get.UserGetCommand;
import com.woojoovove.ddd11.user.application.register.UserRegisterCommand;
import com.woojoovove.ddd11.user.application.update.UserUpdateCommand;
import com.woojoovove.ddd11.user.domain.*;
import com.woojoovove.ddd11.user.infrastructure.IUserRepository;

import java.util.List;

public class UserApplicationService {
    private final IUserRepository userRepository;
    private final IUserFactory userFactory;

    public UserApplicationService(IUserRepository userRepository, IUserFactory userFactory) {
        this.userRepository = userRepository;
        this.userFactory = userFactory;
    }

    // 다른 도메인 서비스 (e.g. CircleAppllicationService)가
    // leader를 세우기 위해서 받은 user가 존재하는 유저인지 판단하기 위해서
    // UserRepository를 직접 사용하는 대신
    // UserApplicationService가 user 존재 여부를 확인하는 메소드를 제공해주는 게 알맞음.
    public User findOrNull(UserId userId) {
        return userRepository.findOrNull(userId);
    }

    public void register(UserRegisterCommand registerCommand) {
        UserName userName = new UserName(registerCommand.getUserName());
        User user = userFactory.create(userName);
        userRepository.save(user);
    }

    public UserData get(UserGetCommand getCommand) {
        UserId userId = getCommand.getId();
        User user = userRepository.findOrNull(userId);
        if (user == null) throw new IllegalStateException("user not found");
        return new UserData(user);
    }

    public void update(UserUpdateCommand updateCommand) {
        UserId id = new UserId(updateCommand.getId());
        User user = userRepository.findOrNull(id);
        if (user == null) throw new IllegalStateException("user not found");
        if (updateCommand.getName() != null) {

            UserName name = new UserName(updateCommand.getName());
            user.changeName(name);
        }
        userRepository.save(user);
    }

    public List<UserData> getAll() {
        return userRepository.findAll().stream().map(UserData::new).toList();
    }

    public void delete(UserDeleteCommand deleteCommand) {

        UserId id = new UserId(deleteCommand.getId());
        User user = userRepository.findOrNull(id);
        if (user == null) return;
        userRepository.deleteById(id);
    }
}
