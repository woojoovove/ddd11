package circle.application.create;

import circle.domain.CircleName;
import user.domain.UserId;

public class CircleCreateCommand {
    private final CircleName name;
    private final UserId ownerId;

    public CircleCreateCommand(CircleName name, UserId ownerId) {
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
