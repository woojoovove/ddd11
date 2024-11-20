package com.woojoovove.ddd11.user.infrastructure;

import com.woojoovove.ddd11.user.domain.User;
import com.woojoovove.ddd11.user.domain.UserId;

import java.util.List;

public interface IUserRepository {
    void save(User user);
    User findOrNull(UserId userId);
    List<User> findAll();
    void deleteById(UserId userId);
}