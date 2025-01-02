package com.woojoovove.ddd11.user.application.common;

import com.woojoovove.ddd11.user.domain.User;
import com.woojoovove.ddd11.user.domain.UserId;
import com.woojoovove.ddd11.user.domain.UserName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UserDataTest {
    @Test
    public void returnTrueWhenCompareGivenSameValue() {
        UserId userId = new UserId("id");
        UserName userName = new UserName("name");
        User user = User.create(userId, userName);
        UserData userData = new UserData(user);

        UserId otherUserId = new UserId("id");
        UserName otherUserName = new UserName("name");
        User otherUser = User.create(otherUserId, otherUserName);
        UserData otherUserData = new UserData(otherUser);

        assertTrue(userData.equals(otherUserData));
    }

    @Test
    public void returnFalseWhenCompareGivenDifferentIdValue() {
        UserId userId = new UserId("id");
        UserName userName = new UserName("name");
        User user = User.create(userId, userName);
        UserData userData = new UserData(user);

        UserId differentId = new UserId("id2");
        UserName otherUserName = new UserName("name");
        User otherUser = User.create(differentId, otherUserName);
        UserData otherUserData = new UserData(otherUser);

        assertFalse(userData.equals(otherUserData));
    }

    @Test
    public void returnFalseWhenCompareGivenDifferentNameValue() {
        UserId userId = new UserId("id");
        UserName userName = new UserName("name");
        User user = User.create(userId, userName);
        UserData userData = new UserData(user);

        UserId otherUserId = new UserId("id");
        UserName differentUserName = new UserName("name2");
        User otherUser = User.create(otherUserId, differentUserName);
        UserData otherUserData = new UserData(otherUser);

        assertFalse(userData.equals(otherUserData));
    }

    @Test
    public void returnFalseWhenCompareGivenDifferentValue() {
        UserId userId = new UserId("id");
        UserName userName = new UserName("name");
        User user = User.create(userId, userName);
        UserData userData = new UserData(user);

        UserId differentUserId = new UserId("id2");
        UserName differentUserName = new UserName("name2");
        User otherUser = User.create(differentUserId, differentUserName);
        UserData otherUserData = new UserData(otherUser);

        assertFalse(userData.equals(otherUserData));
    }

    @Test
    public void returnFalseWhenCompareGivenNull() {
        UserId userId = new UserId("id");
        UserName userName = new UserName("name");
        User user = User.create(userId, userName);
        UserData userData = new UserData(user);

        assertFalse(userData.equals(null));
    }

    @Test
    public void returnFalseWhenCompareGivenDifferentClass() {
        UserId userId = new UserId("id");
        UserName userName = new UserName("name");
        User user = User.create(userId, userName);
        UserData userData = new UserData(user);

        assertFalse(userData.equals(userId));
    }
}
