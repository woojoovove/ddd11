package com.woojoovove.ddd11.circle.application.create;

import com.woojoovove.ddd11.circle.domain.CircleName;
import com.woojoovove.ddd11.user.domain.UserId;

public class CircleCreateCommand {
    private final CircleName name;
    private final UserId ownerId;

    public CircleCreateCommand(CircleName name, UserId ownerId) {
        if (name == null) throw new RuntimeException("circle name cannot be null");
        if (ownerId == null) throw new RuntimeException("userId cannot be null");
        this.name = name;
        this.ownerId = ownerId;
    }

    public CircleName getName() {
        return name;
    }

    public UserId getOwnerId() {
        return ownerId;
    }
}
