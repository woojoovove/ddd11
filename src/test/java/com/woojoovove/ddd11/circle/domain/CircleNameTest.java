package com.woojoovove.ddd11.circle.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CircleNameTest {
    @Test
    public void failCreateGivenNull() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                ()-> new CircleName(null));
        assertEquals(exception.getMessage(), "value cannot be null");
    }
}
