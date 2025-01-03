package com.woojoovove.ddd11.circle.application;

import com.woojoovove.ddd11.circle.application.create.CircleCreateCommand;
import com.woojoovove.ddd11.circle.domain.CircleName;
import com.woojoovove.ddd11.user.domain.UserId;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CircleCreateCommandTest {

    @Test
    public void throwWhenConstructGivenNullName() {
        RuntimeException exception = assertThrows(RuntimeException.class,
                () -> new CircleCreateCommand(null, new UserId("userId")));

        assertEquals(exception.getMessage(), "circle name cannot be null");
    }

    @Test
    public void throwWhenConstructGivenNullOwnerId() {
        RuntimeException exception = assertThrows(RuntimeException.class,
                () -> new CircleCreateCommand(new CircleName("circleName"), null));

        assertEquals(exception.getMessage(), "userId cannot be null");
    }
}
