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

    @Test
    public void returnTrueWhenSameValue() {
        String one = "value1";
        String another = "value1";
        CircleId oncCircleId = new CircleId(one);
        CircleId anotherCircleId = new CircleId(another);
        assertEquals(oncCircleId, anotherCircleId);
    }

    @Test
    public void returnRightValueWhenGet() {
        String validValue = "circleId";
        CircleId circleId = new CircleId(validValue);
        String givenVaule = circleId.getValue();
        assertEquals(validValue, givenVaule);
    }
}
