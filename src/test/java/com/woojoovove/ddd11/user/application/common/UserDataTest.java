package com.woojoovove.ddd11.user.application.common;

import com.woojoovove.ddd11.user.domain.User;
import com.woojoovove.ddd11.user.domain.UserId;
import com.woojoovove.ddd11.user.domain.UserName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserDataTest {
    @Test
    public void returnTrueWhenCompareGivenSameValue() {
        UserId userId = new UserId("id");
        UserName userName = new UserName("name");
        User user = User.create(userId, userName);
        User otherUser = User.create(userId, userName);
        UserData userData = new UserData(user);
        UserData otherUserData = new UserData(otherUser);

        assertEquals(userData, otherUserData);
    }
}
