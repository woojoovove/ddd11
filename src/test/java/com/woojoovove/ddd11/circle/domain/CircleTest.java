package com.woojoovove.ddd11.circle.domain;

import com.woojoovove.ddd11.user.domain.User;
import com.woojoovove.ddd11.user.domain.UserId;
import com.woojoovove.ddd11.user.domain.UserName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CircleTest {

    @Test
    void throwWhenCreateGivenIdNull() {
        CircleName name = mock(CircleName.class);
        User user = mock(User.class);
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                ()-> Circle.create(null, name, user, new ArrayList<>()));
        assertEquals(exception.getMessage(), "id cannot be null");
    }

    @Test
    void throwWhenCreateGivenNameNull() {
        CircleId id = mock(CircleId.class);
        User user = mock(User.class);
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                ()-> Circle.create(id, null, user, new ArrayList<>()));
        assertEquals(exception.getMessage(), "name cannot be null");
    }

    @Test
    void throwWhenCreateGivenLeaderNull() {
        CircleId id = mock(CircleId.class);
        CircleName name = mock(CircleName.class);
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                ()-> Circle.create(id, name, null, new ArrayList<>()));
        assertEquals(exception.getMessage(), "leader cannot be null");
    }

    @Test
    void throwWhenCreateGivenMembersNull() {
        CircleId id = mock(CircleId.class);
        CircleName name = mock(CircleName.class);
        User user = mock(User.class);
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                ()-> Circle.create(id, name, user, null));
        assertEquals(exception.getMessage(), "members cannot be null");
    }

    @Test
    void throwWhenAddMemberGivenOver30() {
        User user = mock(User.class);
        List<User> members = new ArrayList<>();
        for (int i=0; i<30; i++) {
            members.add(User.create(new UserId(String.valueOf(i)), new UserName(String.valueOf((i+1)*100))));
        }
        Circle circle = Circle.create(
                mock(CircleId.class),
                mock(CircleName.class),
                user,
                members
        );
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                ()->circle.addMember(user));
        assertEquals(exception.getMessage(), "정원 초과");
    }

    @Test
    void throwWhenAddMemberGivenUnder30() {
        User leader = mock(User.class);
        Circle circle = Circle.create(
                mock(CircleId.class),
                mock(CircleName.class),
                leader,
                new ArrayList<>()
        );
        User member = mock(User.class);
        circle.addMember(member);
        assertEquals(1, circle.getMembers().size());
        assertTrue(circle.getMembers().contains(member));
    }
}
