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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class InMemoryCircleRepositoryTest {
    private ICircleRepository circleRepository;

    @BeforeEach
    public void setUp() {
        circleRepository = new InMemoryCircleRepository();
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

}
