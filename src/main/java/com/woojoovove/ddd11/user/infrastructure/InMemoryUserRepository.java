package com.woojoovove.ddd11.user.infrastructure;

import com.woojoovove.ddd11.user.domain.User;
import com.woojoovove.ddd11.user.domain.UserId;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryUserRepository implements IUserRepository {

    private Map<UserId, User> store = new HashMap<>();

    @Override
    public void save(User user) {
        // 저장할 때 깊은 복사를 수행합니다.
        // 얕은 복사를 하면 외부에서 user 객체를 변경했을 때
        // repository에 저장된 데이터도 함께 변경될 수 있기 때문
        // UserId는 immutable 하므로 깊은 복사를 할 필요가 없고
        // 깊은 복사를 하면 별도의 equals() 및 hashCode() 오버라이딩이 없는 한
        // 다른 객체로 취급되어 엔티티 복원(조회)에 차질이 생김.
        // 수정 : UserId에 대해서 equals() 및 hashCode()를 값을 기준으로 오버라이딩 함.
        store.put(user.getId(), User.cloneUser(user));
    }

    @Override
    public User findOrNull(UserId userId) {
        return store.getOrDefault(userId, null);
    }

    @Override
    public List<User> findAll() {
        return new ArrayList<>(store.values());
    }

    @Override
    public void deleteById(UserId userId) {
        store.remove(userId);
    }

}
