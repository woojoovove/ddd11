package com.woojoovove.ddd11.circle.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CircleIdTest {
    @Test
    public void failCreateCircleIdWhenNull() {
        String nullValue = null;

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                ()-> new CircleId(nullValue));
        assertEquals("circleId cannot be null or empty", exception.getMessage());
    }
}
