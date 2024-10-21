package domain.user;

public class UserId {
    private final String value;

    public UserId(String value) {
        if (value == null || value.isEmpty()) throw new IllegalArgumentException("user id cannot be null or empty");
        this.value = value;
    }
}
