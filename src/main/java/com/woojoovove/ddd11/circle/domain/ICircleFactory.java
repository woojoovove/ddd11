package circle.domain;

import user.domain.User;

public interface ICircleFactory {
    Circle create(CircleName name, User owner);
}
