package domain.user;

import java.util.HashMap;
import java.util.Map;

public class InMemoryUserRepository implements IUserRepository {

    private Map<UserId, User> store = new HashMap<>();

    @Override
    public void save(User user) {
        // 저장할 때 깊은 복사를 수행합니다.
        // 얕은 복사를 하면 외부에서 user 객체를 변경했을 때
        // repository에 저장된 데이터도 함께 변경될 수 있기 때문
        // UserId는 immutable 하므로 깊은 복사를 할 필요가 없고
        // 깊은 복사를 하면 별도의 equals() 및 hashCode() 오버라이딩이 없는한
        // 다른 객체로 취급되어 엔티티 복원(조회)에 차질이 생김.
        store.put(user.getId(), cloneUser(user));
    }

    @Override
    public User findOrNull(UserId userId) {
        return store.getOrDefault(userId, null);
    }

}
