package com.woojoovove.ddd11.user.application;

import com.woojoovove.ddd11.user.application.common.UserData;
import com.woojoovove.ddd11.user.application.get.UserGetCommand;
import com.woojoovove.ddd11.user.application.register.UserRegisterCommand;
import com.woojoovove.ddd11.user.domain.*;
import com.woojoovove.ddd11.user.infrastructure.IUserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class UserApplicationServiceInMemoryTest {
    
    private IUserRepository userRepository;
    private IUserFactory userFactory;
    private UserApplicationService userApplicationService;

    // 단위 테스트로서 의존성은 mock으로 대체
    @BeforeEach
    void setUp() {
        userRepository = mock(IUserRepository.class);
        userFactory = mock(IUserFactory.class);
        userApplicationService = new UserApplicationService(userRepository, userFactory);
    }

    /**
     * 1) UserName 객체의 유효성은 UserName 클래스 테스트에서 수행하면 됨.
     * 2) 여기서는 UserRegisterCommand를 통해 사용자를 등록하려고 할 때
     *    서비스 레벨에서 예외 처리가 제대로 이루어지는지 테스트함.
     * 3) 2)를 테스트하기 위해서 3자 미만 케이스만 테스트 함.
     *    UserName 클래스에서 이미 3자 미만 & 20자 초과 각각의 케이스에 대해서 테스트하기 때문.
     */
    @Test
    public void failRegisterUserWhenGivenInvalidInput() {

        String invalidInput = "AB";
        UserRegisterCommand registerCommand = new UserRegisterCommand(invalidInput);

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> userApplicationService.register(registerCommand));
        assertEquals("User name length must be at least 3", exception.getMessage());
    }

    @Test
    public void succeedRegisterUserWhenGivenValidInput() {
        String validInput = "ABC";
        UserRegisterCommand registerCommand = new UserRegisterCommand(validInput);
        UserName userName = new UserName(validInput);
        User mockUser = mock(User.class);

        when(userFactory.create(userName)).thenReturn(mockUser);
        userApplicationService.register(registerCommand);

        verify(userFactory, times(1)).create(userName);
        verify(userRepository, times(1)).save(mockUser);
    }

    @Test
    public void returnUserWhenFindOrNullGivenExistingUserId() {
        UserId userId = new UserId("id");
        User mockUser = mock(User.class);

        when(userRepository.findOrNull(userId)).thenReturn(mockUser);
        assertEquals(userApplicationService.findOrNull(userId), mockUser);
        verify(userRepository).findOrNull(userId);
    }

    @Test
    public void returnNullWhenFindOrNullGivenNonExistingUserId() {
        UserId userId = new UserId("id");

        when(userRepository.findOrNull(userId)).thenReturn(null);
        assertEquals(userApplicationService.findOrNull(userId), null);
        verify(userRepository).findOrNull(userId);
    }

    @Test
    public void throwWhenGetDataGivenNonExistingUserId() {
        UserId userId = new UserId("id");
        UserGetCommand getCommand = new UserGetCommand(userId);
        when(userRepository.findOrNull(userId)).thenReturn(null);
        IllegalStateException exception = assertThrows(IllegalStateException.class,
                () -> userApplicationService.get(getCommand));
        assertEquals(exception.getMessage(), "user not found");
    }

    @Test
    public void returnUserDataWhenGetDataGivenValidInput() {
        UserId userId = new UserId("id");
        UserGetCommand getCommand = new UserGetCommand(userId);
        User user = User.create(userId, new UserName("name"));
        when(userRepository.findOrNull(userId)).thenReturn(user);
        UserData userData = userApplicationService.get(getCommand);
        assertEquals(userData, new UserData(user));
    }

    @Test
    public void returnUserDataListWhenGetAll() {
        assertNotNull(userApplicationService.getAll());
        verify(userRepository).findAll();
    }
}
