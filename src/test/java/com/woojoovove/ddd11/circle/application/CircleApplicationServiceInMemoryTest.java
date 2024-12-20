package com.woojoovove.ddd11.circle.application;

import com.woojoovove.ddd11.circle.application.create.CircleCreateCommand;
import com.woojoovove.ddd11.circle.application.join.CircleJoinCommand;
import com.woojoovove.ddd11.circle.domain.Circle;
import com.woojoovove.ddd11.circle.domain.CircleId;
import com.woojoovove.ddd11.circle.domain.CircleName;
import com.woojoovove.ddd11.circle.domain.ICircleFactory;
import com.woojoovove.ddd11.circle.infrastructure.ICircleRepository;
import com.woojoovove.ddd11.user.application.UserApplicationService;
import com.woojoovove.ddd11.user.domain.User;
import com.woojoovove.ddd11.user.domain.UserId;
import com.woojoovove.ddd11.user.domain.UserName;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

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

    @Test
    void throwExceptionWhenCreateGivenExistCircleName() {

        UserId userId = new UserId("userId");
        CircleName circleName = new CircleName("circleName");
        CircleCreateCommand createCommand = new CircleCreateCommand(circleName, userId);
        User mockUser = User.create(userId, new UserName("userName"));


        when(userApplicationService.findOrNull(userId)).thenReturn(mockUser);
        when(circleRepository.findByNameOrNull(circleName)).thenReturn(Circle.create(new CircleId("circleId"), circleName, mockUser, new ArrayList<>()));

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> circleApplicationService.createCircle(createCommand)
        );

        assertEquals("circle already exists", exception.getMessage());

        verify(circleRepository).findByNameOrNull(circleName);
        verifyNoMoreInteractions(circleFactory);
        verifyNoMoreInteractions(circleRepository);
    }

    @Test
    void succeedCreateGivenNonExistCircleName() {

        UserId userId = new UserId("userId");
        CircleName circleName = new CircleName("circleName");
        CircleCreateCommand createCommand = new CircleCreateCommand(circleName, userId);
        User mockUser = User.create(userId, new UserName("userName"));


        when(userApplicationService.findOrNull(userId)).thenReturn(mockUser);
        when(circleRepository.findByNameOrNull(circleName)).thenReturn(null);
        Circle mockCircle = mock(Circle.class);
        when(circleFactory.create(circleName, mockUser)).thenReturn(mockCircle);

        circleApplicationService.createCircle(createCommand);

        verify(circleRepository).findByNameOrNull(circleName);
        verify(circleFactory).create(circleName, mockUser);
        verify(circleRepository).save(mockCircle);
    }

    @Test
    void throwWhenJoinCircleGivenNonExistCircle() {
        CircleJoinCommand joinCommand = new CircleJoinCommand(new CircleId("nonExisting"), new UserId("userId"));
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> circleApplicationService.joinCircle(joinCommand));
        assertEquals(exception.getMessage(), "circle not found");
    }

    @Test
    void throwWhenJoinCircleGivenNonExistUser() {
        CircleId circleId = new CircleId("circleId");
        CircleJoinCommand joinCommand = new CircleJoinCommand(circleId, new UserId("userId"));
        when(circleRepository.findByIdOrNull(circleId)).thenReturn(mock(Circle.class));
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> circleApplicationService.joinCircle(joinCommand));
        assertEquals(exception.getMessage(), "user not found");
    }

    @Test
    void succeedWhenJoinCircleGivenExistCircleAndUser() {
        CircleId circleId = new CircleId("circleId");
        Circle mockCircle = mock(Circle.class);
        when(circleRepository.findByIdOrNull(circleId)).thenReturn(mockCircle);

        UserId userId = new UserId("userId");
        User mockUser = User.create(userId, new UserName("userName"));
        when(userApplicationService.findOrNull(userId)).thenReturn(mockUser);

        CircleJoinCommand joinCommand = new CircleJoinCommand(circleId, userId);
        circleApplicationService.joinCircle(joinCommand);

        verify(mockCircle).addMember(mockUser);
        verify(circleRepository).save(mockCircle);
    }
}
