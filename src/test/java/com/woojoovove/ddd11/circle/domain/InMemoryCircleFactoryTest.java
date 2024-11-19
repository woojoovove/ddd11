package com.woojoovove.ddd11.circle.domain;

import com.woojoovove.ddd11.user.domain.User;
import com.woojoovove.ddd11.user.domain.UserId;
import com.woojoovove.ddd11.user.domain.UserName;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class InMemoryCircleFactoryTest {
    private InMemoryCircleFactory circleFactory;
    @BeforeEach
    public void setUp() {
        circleFactory = new InMemoryCircleFactory();
    }

    @Test
    public void succeedCreateUser() {
        CircleName circleName = new CircleName("valid");
        UserId userId = new UserId("userid");
        UserName userName = new UserName("username");
        User user = User.create(userId, userName);
        Circle circle = circleFactory.create(circleName, user);
        assertNotNull(circle);
        assertEquals(circle.getName(), circleName);
        assertEquals(circle.getLeader().getId(), user.getId());
    }
}
