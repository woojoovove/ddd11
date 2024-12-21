package com.woojoovove.ddd11.user.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UserNameTest {
    @Test
    public void failConstructWhenGivenNull() {
        String nullValue = null;
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> new UserName(nullValue));
        assertEquals("value cannot be null", exception.getMessage());
    }
    @Test
    public void failConstructWhenGivenTooShort() {
        String tooShort = "A";
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> new UserName(tooShort));
        assertEquals("User name length must be at least 3", exception.getMessage());
    }
    @Test
    public void failConstructWhenGivenTooLong() {
        String tooLong = "012345678901234567890";
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> new UserName(tooLong));
        assertEquals("User name length must not be longer than 20", exception.getMessage());
    }

    @Test
    public void succeedConstructWhenGivenValid() {
        String validName = "valid";
        UserName name = new UserName(validName);

        assertEquals(name.getValue(), validName);
    }

    @Test
    public void returnTrueWhenGivenSameValueAndFalseWhenGivenDifferentValue() {
        UserName wawa = new UserName("wawa");
        UserName wawa2 = new UserName("wawa");
        UserName chiwawa = new UserName("chiwawa");

        assertEquals(wawa, wawa2);
        assertNotEquals(wawa, chiwawa);
    }

    @Test
    public void returnSameHashCodeWhenGivenSameValue() {
        UserName wawa = new UserName("wawa");
        UserName wawa2 = new UserName("wawa");

        assertEquals(wawa.hashCode(), wawa2.hashCode());
    }

    @Test
    public void returnFalseWhenComparedGivenDifferentClass() {
        UserName wawa = new UserName("wawa");
        UserId id = new UserId("id");
        assertFalse(wawa.equals(id));
    }


}
