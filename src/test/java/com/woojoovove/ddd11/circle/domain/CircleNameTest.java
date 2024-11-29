package com.woojoovove.ddd11.circle.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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

    @Test
    public void failCreateCircleNameGivenTooLong() {
        String tooLong = "012345678901234567890";
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
        ()-> new CircleName(tooLong));
        assertEquals(exception.getMessage(), "Circle name length must not be longer than 20");
    }

    @Test
    public void returnRightValueWhenGet() {
        String value = "circleName";
        CircleName circleName = new CircleName(value);
        assertEquals(value, circleName.getValue());
    }

    @Test
    public void returnTrueWhenGivenSameObject() {
        CircleName circleName = new CircleName("circleName");
        assertEquals(circleName, circleName);
    }

    @Test
    public void returnTrueWhenCompareGivenSameValue() {
        CircleName circleName = new CircleName("circleName");
        CircleName sameName = new CircleName("circleName");
        assertEquals(circleName, sameName);
    }

    @Test
    public void returnFalseWhenCompareGivenDifferentValue() {
        CircleName circleName = new CircleName("circleName");
        CircleName differentName = new CircleName("differentValue");
        assertNotEquals(circleName, differentName);
    }

    @Test
    public void returnSameHashCodeGivenSameValue() {

    }
}
