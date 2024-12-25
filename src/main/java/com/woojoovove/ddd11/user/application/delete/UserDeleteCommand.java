package com.woojoovove.ddd11.user.application.delete;

import com.woojoovove.ddd11.user.domain.UserId;

public class UserDeleteCommand {
    private final UserId id;

    public UserDeleteCommand(UserId id) {
        this.id = id;
    }

    public UserId getId() {
        return id;
    }
}
