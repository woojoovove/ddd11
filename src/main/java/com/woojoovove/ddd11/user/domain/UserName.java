package com.woojoovove.ddd11.user.domain;

public class UserName {
    private final String value;

    public UserName(String value) {
        if (value == null) throw new IllegalArgumentException("value cannot be null");
        if (value.length()<3) throw new IllegalArgumentException("User name length must be at least 3");
        if (value.length()>20) throw new IllegalArgumentException("User name length must not be longer than 20");
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
