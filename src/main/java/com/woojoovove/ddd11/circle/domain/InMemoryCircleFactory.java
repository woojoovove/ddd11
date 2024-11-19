package com.woojoovove.ddd11.circle.domain;

import com.woojoovove.ddd11.user.domain.User;

import java.util.ArrayList;
import java.util.UUID;

public class InMemoryCircleFactory implements ICircleFactory {
    @Override
    public Circle create(CircleName name, User owner) {
        CircleId id = new CircleId(UUID.randomUUID().toString());
        return Circle.create(id, name, owner, new ArrayList<>());
    }
}
