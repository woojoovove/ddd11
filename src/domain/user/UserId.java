package domain.user;

import java.util.Objects;

public class UserId {
    private final String value;

    public UserId(String value) {
        if (value == null || value.isEmpty()) throw new IllegalArgumentException("user id cannot be null or empty");
        this.value = value;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true; // Check for reference equality
        if (obj == null || getClass() != obj.getClass()) return false; // Check for null and class type
        UserId userId = (UserId) obj; // Cast to UserId
        return Objects.equals(value, userId.value); // Compare the values
    }

    @Override
    public int hashCode() {
        return Objects.hash(value); // Generate hash code based on value
    }

    public String getValue() {
        return value; // Getter for value
    }
}
