package application.user;

import domain.user.*;

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
}
