package com.woojoovove.ddd11.circle.domain;

import java.util.Objects;

public class CircleId {
    private final String value;

    public CircleId(String value) {
        if (value == null || value.isEmpty()) throw new IllegalArgumentException("circleId cannot be null or empty");
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
        if (obj == null || obj.getClass() != getClass()) return false;
        CircleId circleId = (CircleId) obj;
        return circleId.getValue().equals(value);
    }
}
