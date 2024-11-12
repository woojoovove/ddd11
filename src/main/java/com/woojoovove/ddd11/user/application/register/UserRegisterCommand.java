package com.woojoovove.ddd11.user.application.register;

public class UserRegisterCommand {
    private String userName;

    public UserRegisterCommand(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }
}
