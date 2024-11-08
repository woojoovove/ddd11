package com.woojoovove.ddd11.user.domain;

import java.util.UUID;

// 테스트와 운영에 각각 다른 생성방식을 적용하기 위해서 인터페이스로 구현
public class InMemoryUserFactory implements IUserFactory {

    @Override
    public User create(UserName userName) {
        UserId id = new UserId(UUID.randomUUID().toString());
        return User.create(id, userName);
    }
}
