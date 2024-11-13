package com.woojoovove.ddd11.user.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class UserTest {
    private UserId id;
    private UserName name;
    private User user;

    @Test
    public void failCreateUserWhenGivenNullId() {
        id = null;
        name = new UserName("ABC");
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> User.create(id, name));
        assertEquals("id cannot be null", exception.getMessage());
    }

    public void succeedCreateUserWhenGivenNotNull() {

    }

    public void failChangeNameWhenGivenNull() {}
    public void succeedChangeNameWhenGivenNotNull() {}
    public void cloneUserWithIndependentCopyWithSameValue() {}
}
