package com.woojoovove.ddd11.user.application.get;

import com.woojoovove.ddd11.user.domain.UserId;

public class UserGetCommand {
    private UserId id;

    public UserGetCommand(UserId id) {
        this.id = id;
    }

    public UserId getId() {
        return id;
    }
}
