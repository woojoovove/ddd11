package com.woojoovove.ddd11.user.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class UserIdTest {

    @Test
    public void failConstructWhenGivenNullValue() {
        String nullValue = null;
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                ()-> new UserId(nullValue));
        assertEquals("user id cannot be null or empty", exception.getMessage());
    }

    @Test
    public void failConstructWhenGivenEmptyValue() {
        String emptyValue = "";
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                ()-> new UserId(emptyValue));
        assertEquals("user id cannot be null or empty", exception.getMessage());
    }

}
