package domain.user;

public interface IUserRepository {
    void save(User user);
    User findOrNull(UserId userId);
}