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
}
