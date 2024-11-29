package com.woojoovove.ddd11.circle.domain;

import java.util.Objects;

public class CircleName {
    private final String value;

    public CircleName(String value) {
        if (value == null) throw new IllegalArgumentException("value cannot be null");
        if (value.length()<3) throw new IllegalArgumentException("Circle name length must be at least 3");
        if (value.length()>20) throw new IllegalArgumentException("Circle name length must not be longer than 20");
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj.getClass() != getClass() || obj == null) return false;
        CircleName circleName = (CircleName) obj;
        return circleName.getValue().equals(value);
    }
}
