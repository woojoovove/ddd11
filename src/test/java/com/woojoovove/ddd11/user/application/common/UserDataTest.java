package com.woojoovove.ddd11.user.application.common;

import com.woojoovove.ddd11.user.domain.User;
import com.woojoovove.ddd11.user.domain.UserId;
import com.woojoovove.ddd11.user.domain.UserName;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UserDataTest {

    private UserData userData;
    private UserId userId;
    @BeforeEach
    public void setUp() {
        userId = new UserId("id");
        UserName userName = new UserName("name");
        User user = User.create(userId, userName);
        userData = new UserData(user);
    }

    @Test
    public void returnTrueWhenCompareGivenSameValue() {

        UserId otherUserId = new UserId("id");
        UserName otherUserName = new UserName("name");
        User otherUser = User.create(otherUserId, otherUserName);
        UserData otherUserData = new UserData(otherUser);

        assertEquals(userData, otherUserData);
    }

    @Test
    public void returnFalseWhenCompareGivenDifferentIdValue() {

        UserId differentId = new UserId("id2");
        UserName otherUserName = new UserName("name");
        User otherUser = User.create(differentId, otherUserName);
        UserData otherUserData = new UserData(otherUser);

        assertNotEquals(userData, otherUserData);
    }

    @Test
    public void returnFalseWhenCompareGivenDifferentNameValue() {

        UserId otherUserId = new UserId("id");
        UserName differentUserName = new UserName("name2");
        User otherUser = User.create(otherUserId, differentUserName);
        UserData otherUserData = new UserData(otherUser);

        assertNotEquals(userData, otherUserData);
    }

    @Test
    public void returnFalseWhenCompareGivenDifferentValue() {

        UserId differentUserId = new UserId("id2");
        UserName differentUserName = new UserName("name2");
        User otherUser = User.create(differentUserId, differentUserName);
        UserData otherUserData = new UserData(otherUser);

        assertNotEquals(userData, otherUserData);
    }

    @Test
    public void returnFalseWhenCompareGivenNull() {
        assertNotEquals(userData, null);
    }

    @Test
    public void returnFalseWhenCompareGivenDifferentClass() {
        assertNotEquals(userData, userId);
    }

    @Test
    public void returnTrueWhenCompareGivenSameObject() {
        assertEquals(userData, userData);
    }

    @Test
    public void hashCodeShouldBeConsistent(){
        assertEquals(userData.hashCode(), userData.hashCode());
    }
}
