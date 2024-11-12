package com.woojoovove.ddd11.user.application;

import com.woojoovove.ddd11.user.application.register.UserRegisterCommand;
import com.woojoovove.ddd11.user.domain.IUserFactory;
import com.woojoovove.ddd11.user.domain.IUserRepository;
import com.woojoovove.ddd11.user.domain.InMemoryUserFactory;
import com.woojoovove.ddd11.user.domain.InMemoryUserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class UserApplicationServiceInMemoryTest {
    
    private IUserRepository userRepository;
    private IUserFactory userFactory;
    private UserApplicationService userApplicationService;
    @BeforeEach
    void setUp() {
        userRepository = new InMemoryUserRepository();
        userFactory = new InMemoryUserFactory();
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

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () ->{
            userApplicationService.register(registerCommand);
        });
        assertEquals("User name length must be at least 3", exception.getMessage());
    }
}
