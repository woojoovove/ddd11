package com.woojoovove.ddd11.user.application.common;

import com.woojoovove.ddd11.user.domain.User;

import java.util.Objects;

public class UserData {
    private String id;
    private String name;

    public UserData(User user) {
        this.id = user.getId().getValue();
        this.name = user.getName().getValue();
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || obj.getClass() != getClass()) return false;
        UserData userData = (UserData) obj;
        return Objects.equals(userData.id, id) && Objects.equals(userData.name, name);
    }
}
