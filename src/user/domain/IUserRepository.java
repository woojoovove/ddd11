package user.domain;

import java.util.List;

public interface IUserRepository {
    void save(User user);
    User findOrNull(UserId userId);

    List<User> findAll();
}