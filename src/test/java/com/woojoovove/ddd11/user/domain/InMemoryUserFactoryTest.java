package com.woojoovove.ddd11.user.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

public class InMemoryUserFactoryTest {

    private InMemoryUserFactory userFactory;
    @BeforeEach
    public void setUp() {
        userFactory = new InMemoryUserFactory();
    }
    @Test
    public void succeedCreateUser() {
        UserName userName = new UserName("userName");
        User user = userFactory.create(userName);
        assertNotNull(user);
        assertNotNull(user.getId());
        assertDoesNotThrow(()->UUID.fromString(user.getId().getValue()));
        assertEquals(userName, user.getName());
    }
    @Test
    public void createDifferentUserWithSameNameValue() {
        UserName userName = new UserName("userName");
        User user = userFactory.create(userName);
        User anotherUser = userFactory.create(userName);
        assertNotEquals(user, anotherUser);
    }
}
