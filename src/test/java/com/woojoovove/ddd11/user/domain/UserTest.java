package com.woojoovove.ddd11.user.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UserTest {
    private UserId id;
    private UserName name;
    private User user;

    @Test
    public void failCreateUserWhenGivenNullId() {
        id = null;
        name = new UserName("ABC");
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> User.create(id, name));
        assertEquals("id cannot be null", exception.getMessage());
    }

    @Test
    public void failCreateUserWhenGivenNullName() {
        id = new UserId("id");
        name = null;
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> User.create(id, name));
        assertEquals("name cannot be null", exception.getMessage());
    }

    @Test
    public void succeedCreateUserWhenGivenNotNull() {
        id = new UserId("id");
        name = new UserName("ABC");
        User user = User.create(id, name);
        assertNotNull(user);
        assertEquals(id, user.getId());
        assertEquals(name, user.getName());
    }

    @Test
    public void failChangeNameWhenGivenNull() {
        id = new UserId("id");
        name = new UserName("ABC");
        User user = User.create(id, name);
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                ()-> user.changeName(null));
        assertEquals("name cannot be null", exception.getMessage());
    }


}
