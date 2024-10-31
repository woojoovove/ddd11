package domain.circle;

import domain.user.User;

public interface ICircleFactory {
    Circle create(CircleName name, User owner);
}
