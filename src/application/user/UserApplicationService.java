package application.user;

import domain.user.*;

public class UserApplicationService {
    private final IUserRepository userRepository;
    private final IUserFactory userFactory;

    public UserApplicationService(IUserRepository userRepository, IUserFactory userFactory) {
        this.userRepository = userRepository;
        this.userFactory = userFactory;
    }

    public User findOrNull(UserId userId) {
        return userRepository.findOrNull(userId);
    }
}
