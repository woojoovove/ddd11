package com.woojoovove.ddd11.circle.domain;

import java.util.HashMap;
import java.util.Map;

import static com.woojoovove.ddd11.circle.domain.Circle.cloneCircle;

public class InMemoryCircleRepository implements ICircleRepository {
    private Map<CircleId, Circle> store = new HashMap<>();


    @Override
    public Circle findByNameOrNull(CircleName circleName) {
        for (Map.Entry<CircleId, Circle> entry : store.entrySet()) {
            if (entry.getValue().getName().equals(circleName)) return store.get(entry.getKey());
        }
        return null;
    }

    @Override
    public Circle findByIdOrNull(CircleId circleId) {
        return store.getOrDefault(circleId, null);
    }

    @Override
    public void save(Circle circle) {
        store.put(circle.getId(), cloneCircle(circle));
    }

}
