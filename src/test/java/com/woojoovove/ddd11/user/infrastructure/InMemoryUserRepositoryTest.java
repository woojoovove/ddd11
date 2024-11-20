package com.woojoovove.ddd11.user.infrastructure;

import com.woojoovove.ddd11.user.application.common.UserData;
import com.woojoovove.ddd11.user.domain.User;
import com.woojoovove.ddd11.user.domain.UserId;
import com.woojoovove.ddd11.user.domain.UserName;
import com.woojoovove.ddd11.user.infrastructure.InMemoryUserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class InMemoryUserRepositoryTest {

    private InMemoryUserRepository repository;
    @BeforeEach
    public void setUp() {
        repository = new InMemoryUserRepository();
    }
    @Test
    public void succeedSave() {

        UserName name = new UserName("ABC");
        UserId id = new UserId("AAA");
        repository.save(User.create(id, name));
        User found = repository.findOrNull(id);
        assertNotNull(found);
        assertEquals(id, found.getId());
        assertEquals(name, found.getName());
    }

    @Test
    public void returnNullGivenNonExistUser() {
        UserId id = new UserId("AAA");
        assertNull(repository.findOrNull(id));
    }

    @Test
    public void returnAllUser() {
        User user1= User.create(new UserId("aaa"), new UserName("bbb"));
        User user2= User.create(new UserId("ccc"), new UserName("ddd"));
        repository.save(user1);
        repository.save(user2);

        List<UserData> users = repository.findAll().stream().map(UserData::new).toList();
        assertEquals(2, users.size());
        assertTrue(users.contains(new UserData(user1)));
        assertTrue(users.contains(new UserData(user2)));

    }

    @Test
    public void deleteUserFromRepository() {
        UserName name = new UserName("ABC");
        UserId id = new UserId("AAA");
        User user1= User.create(id, name);
        repository.save(user1);

        UserName name2 = new UserName("ZZZ");
        UserId id2 = new UserId("XXX");
        User user2= User.create(id2, name2);
        repository.save(user2);

        repository.deleteById(id);
        assertNull(repository.findOrNull(id));
        assertNotNull(repository.findOrNull(id2));
    }
}
