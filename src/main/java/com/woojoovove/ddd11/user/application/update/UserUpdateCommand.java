package com.woojoovove.ddd11.user.application.update;

import com.woojoovove.ddd11.user.domain.UserId;
import com.woojoovove.ddd11.user.domain.UserName;

public class UserUpdateCommand {
    private final UserId id;
    private final UserName name;

    public UserUpdateCommand(UserId id, UserName name) {
        this.id = id;
        this.name = name;
    }

    public UserId getId() {
        return id;
    }

    public UserName getName() {
        return name;
    }
}
