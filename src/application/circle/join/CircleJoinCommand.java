package application.circle.join;

import domain.circle.CircleId;
import domain.user.UserId;

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
