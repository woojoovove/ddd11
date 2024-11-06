package user.domain;

public interface IUserRepository {
    void save(User user);
    User findOrNull(UserId userId);
}