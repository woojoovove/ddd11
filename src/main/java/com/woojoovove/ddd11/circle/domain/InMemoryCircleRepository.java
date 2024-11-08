package com.woojoovove.ddd11.circle.domain;

import java.util.HashMap;
import java.util.Map;

public class InMemoryCircleRepository implements ICircleRepository {
    private Map<CircleId, Circle> store = new HashMap<>();


    @Override
    public Circle findByNameOrNull(CircleName circleName) {
        return null;
    }

    @Override
    public Circle findByIdOrNull(CircleId circleId) {
        return null;
    }

    @Override
    public void save(Circle circle) {
        store.put(circle.getId(), cloneCircle(circle));
    }

    private Circle cloneCircle(Circle circle) {
        return Circle.create(circle.getId(), circle.getName(), circle.getLeader(), circle.getMembers());
    }
}
