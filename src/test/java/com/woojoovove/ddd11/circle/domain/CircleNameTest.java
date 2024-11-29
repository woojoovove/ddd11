package com.woojoovove.ddd11.circle.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CircleNameTest {
    @Test
    public void failCreateCircleNameGivenNull() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                ()-> new CircleName(null));
        assertEquals(exception.getMessage(), "value cannot be null");
    }

    @Test
    public void failCreateCircleNameGivenTooShort() {
        String tooShort = "ab";
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                ()-> new CircleName(tooShort));
        assertEquals(exception.getMessage(), "Circle name length must be at least 3");
    }
}
