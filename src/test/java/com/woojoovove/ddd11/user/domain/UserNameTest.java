package com.woojoovove.ddd11.user.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class UserNameTest {
    @Test
    public void failConstructWhenGivenNull() {
        String nullValue = null;
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> new UserName(nullValue));
        assertEquals("value cannot be null", exception.getMessage());
    }
    @Test
    public void failConstructWhenGivenTooShort() {
        String tooShort = "A";
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> new UserName(tooShort));
        assertEquals("User name length must be at least 3", exception.getMessage());
    }
    @Test
    public void failConstructWhenGivenTooLong() {
        String tooLong = "012345678901234567890";
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> new UserName(tooLong));
        assertEquals("User name length must not be longer than 20", exception.getMessage());
    }

}
