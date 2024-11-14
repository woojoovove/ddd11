package com.woojoovove.ddd11.user.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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

    @Test
    public void succeedConstructWhenGivenValidValue() {
        String valid = "id";
        UserId id = new UserId(valid);
        assertEquals(valid, id.getValue());
    }

    @Test
    public void returnTrueGivenEqualValueAndFalseGivenDifferentValue() {
        UserId id = new UserId("id");
        UserId id2 = new UserId("id");
        UserId differentId = new UserId("differentId");

        assertEquals(id, id2);
        assertNotEquals(id, differentId);
    }

    @Test
    public void returnSameHashCodeGivenSameValue() {
        UserId id = new UserId("id");
        UserId id2 = new UserId("id");

        assertEquals(id.hashCode(), id2.hashCode());
    }

}
