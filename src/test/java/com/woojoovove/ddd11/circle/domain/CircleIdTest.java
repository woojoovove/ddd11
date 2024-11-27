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

    @Test
    public void failCreateCircleIdWhenEmpty() {
        String nullValue = "";

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                ()-> new CircleId(nullValue));
        assertEquals("circleId cannot be null or empty", exception.getMessage());
    }

    @Test
    public void succedCreateIdWhenValid() {
        String validValue = "circleId";
        CircleId circleId = new CircleId(validValue);
        assertEquals(validValue, circleId.getValue());
    }
}
