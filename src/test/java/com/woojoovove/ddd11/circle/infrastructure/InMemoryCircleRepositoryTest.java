package com.woojoovove.ddd11.circle.infrastructure;

import com.woojoovove.ddd11.circle.domain.Circle;
import com.woojoovove.ddd11.circle.domain.CircleId;
import com.woojoovove.ddd11.circle.domain.CircleName;
import com.woojoovove.ddd11.user.domain.User;
import com.woojoovove.ddd11.user.domain.UserId;
import com.woojoovove.ddd11.user.domain.UserName;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class InMemoryCircleRepositoryTest {
    private ICircleRepository circleRepository;
    private Map<CircleId, Circle> store;

    @BeforeEach
    public void setUp() {
        store = new HashMap<>();
        circleRepository = new InMemoryCircleRepository(store);
    }

    @Test
    public void saveCircle() {
        CircleName circleName = new CircleName("circleName");
        CircleId circleId = new CircleId("circleId");
        UserId userId = new UserId("userId");
        UserName userName = new UserName("userName");
        User user = User.create(userId, userName);
        Circle circle = Circle.create(circleId, circleName, user, new ArrayList<>());

        circleRepository.save(circle);
        Circle found = circleRepository.findByIdOrNull(circleId);
        assertNotNull(found);
        assertEquals(circleId, found.getId());
        assertEquals(circleName, found.getName());
        assertEquals(user, found.getLeader());
    }

    @Test
    public void returnNullWhenGivenNonExistingId() {
        CircleId circleId = new CircleId("circleId");
        Circle found = circleRepository.findByIdOrNull(circleId);
        assertNull(found);
    }

    @Test
    public void returnNullWhenGivenNonExistingName() {
        CircleName circleName = new CircleName("circleName");
        Circle found = circleRepository.findByNameOrNull(circleName);
        assertNull(found);
    }

    @Test
    public void returnCircleWhenFindByNameGivenExistingName() {
        CircleName circleName = new CircleName("circleName");
        CircleId circleId = new CircleId("circleId");
        UserId userId = new UserId("userId");
        UserName userName = new UserName("userName");
        User user = User.create(userId, userName);
        Circle circle = Circle.create(circleId, circleName, user, new ArrayList<>());
        store.put(circleId, circle);

        Circle result = circleRepository.findByNameOrNull(circleName);

        assertNotNull(result);
        assertEquals(result, circle);
    }

    @Test
    public void returnCircleWhenFindByNameGivenNonExistingName() {
        CircleName circleName = new CircleName("circleName");
        CircleId circleId = new CircleId("circleId");
        UserId userId = new UserId("userId");
        UserName userName = new UserName("userName");
        User user = User.create(userId, userName);
        Circle circle = Circle.create(circleId, circleName, user, new ArrayList<>());
        store.put(circleId, circle);

        CircleName nonExistingName = new CircleName("non-existent");
        Circle result = circleRepository.findByNameOrNull(nonExistingName);

        assertNull(result);
    }
}
