package com.woojoovove.ddd11.circle.domain;

import com.woojoovove.ddd11.user.domain.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;

public class CircleTest {

    @Test
    void throwWhenCreateGivenIdNull() {
        CircleName name = mock(CircleName.class);
        User user = mock(User.class);
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                ()-> Circle.create(null, name, user, new ArrayList<>()));
        assertEquals(exception.getMessage(), "id cannot be null");
    }

    @Test
    void throwWhenCreateGivenNameNull() {
        CircleId id = mock(CircleId.class);
        User user = mock(User.class);
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                ()-> Circle.create(id, null, user, new ArrayList<>()));
        assertEquals(exception.getMessage(), "name cannot be null");
    }

}
