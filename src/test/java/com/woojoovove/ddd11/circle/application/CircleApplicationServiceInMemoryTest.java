package com.woojoovove.ddd11.circle.application;

import com.woojoovove.ddd11.circle.domain.ICircleFactory;
import com.woojoovove.ddd11.circle.infrastructure.ICircleRepository;
import com.woojoovove.ddd11.user.application.UserApplicationService;
import org.junit.jupiter.api.BeforeEach;

import static org.mockito.Mockito.mock;

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
}
