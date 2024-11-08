package com.woojoovove.ddd11.circle.application.join;

import com.woojoovove.ddd11.circle.domain.CircleId;
import com.woojoovove.ddd11.user.domain.UserId;

public class CircleJoinCommand {
    private final CircleId circleId;
    private final UserId userId;

    public CircleJoinCommand(CircleId circleId, UserId userId) {
        this.circleId = circleId;
        this.userId = userId;
    }

    public CircleId getCircleId() {
        return circleId;
    }

    public UserId getUserId() {
        return userId;
    }
}
