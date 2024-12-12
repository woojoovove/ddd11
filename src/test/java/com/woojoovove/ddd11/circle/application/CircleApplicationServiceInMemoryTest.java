package com.woojoovove.ddd11.circle.application;

import com.woojoovove.ddd11.circle.application.create.CircleCreateCommand;
import com.woojoovove.ddd11.circle.domain.CircleName;
import com.woojoovove.ddd11.circle.domain.ICircleFactory;
import com.woojoovove.ddd11.circle.infrastructure.ICircleRepository;
import com.woojoovove.ddd11.user.application.UserApplicationService;
import com.woojoovove.ddd11.user.domain.UserId;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CircleApplicationServiceInMemoryTest {
    private ICircleFactory circleFactory;
    private ICircleRepository circleRepository;
    private UserApplicationService userApplicationService;
    private CircleApplicationService circleApplicationService;

    @BeforeEach
    void setUp() {
        circleFactory = mock(ICircleFactory.class);
        circleRepository = mock(ICircleRepository.class);
        userApplicationService = mock(UserApplicationService.class);
        circleApplicationService = new CircleApplicationService(circleRepository, circleFactory, userApplicationService);
    }

    @Test
    void throwExceptionWhenCreateGivenNullAsUser() {
        UserId userId = new UserId("userId");
        CircleCreateCommand createCommand = new CircleCreateCommand(new CircleName("name"), userId);
        when(userApplicationService.findOrNull(userId)).thenReturn(null);
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> circleApplicationService.createCircle(createCommand));
        assertEquals(exception.getMessage(), "user not found");
    }
}
