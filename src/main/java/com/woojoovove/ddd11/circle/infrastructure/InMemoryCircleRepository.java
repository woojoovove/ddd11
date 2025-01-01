package com.woojoovove.ddd11.circle.infrastructure;

import com.woojoovove.ddd11.circle.domain.Circle;
import com.woojoovove.ddd11.circle.domain.CircleId;
import com.woojoovove.ddd11.circle.domain.CircleName;

import java.util.Map;

public class InMemoryCircleRepository implements ICircleRepository {
    private final Map<CircleId, Circle> store;

    public InMemoryCircleRepository(Map<CircleId, Circle> store) {
        this.store = store;
    }

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
        store.put(circle.getId(), Circle.cloneCircle(circle));
    }

}
