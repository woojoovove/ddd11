package com.woojoovove.ddd11.circle.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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
        CircleId oncCircleId = new CircleId("value1");
        CircleId anotherCircleId = new CircleId("value1");
        assertEquals(oncCircleId, anotherCircleId);
    }

    @Test
    public void returnRightValueWhenGet() {
        String validValue = "circleId";
        CircleId circleId = new CircleId(validValue);
        String givenVaule = circleId.getValue();
        assertEquals(validValue, givenVaule);
    }

    @Test
    public void returnTrueWhenEqualsSameObject() {
        CircleId circleId = new CircleId("circleId");
        assertEquals(circleId, circleId);
    }

    @Test
    public void returnFalseWhenDifferentValue() {
        CircleId oncCircleId = new CircleId("value1");
        CircleId anotherCircleId = new CircleId("value2");
        assertNotEquals(oncCircleId, anotherCircleId);
    }

    @Test
    public void returnFalseWhenComparedWithNull() {
        CircleId circleId = new CircleId("circle");
        assertNotEquals(null, circleId);
    }

    @Test
    public void hashCodeShouldBeConsistent() {
        CircleId circleId = new CircleId("circle");
        assertEquals(circleId.hashCode(), circleId.hashCode());
    }
}
