package com.woojoovove.ddd11.user.application.common;

import com.woojoovove.ddd11.user.domain.User;

public class UserData {
    private String id;
    private String name;

    public UserData(User user) {
        this.id = user.getId().getValue();
        this.name = user.getName().getValue();
    }
}
