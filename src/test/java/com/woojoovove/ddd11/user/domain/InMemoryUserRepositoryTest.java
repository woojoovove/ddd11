package com.woojoovove.ddd11.user.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

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
}
