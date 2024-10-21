package domain.user;

public class User {
    private final UserId id;
    private UserName name;

    public User(UserId id, UserName name) {
        if (id == null) throw new IllegalArgumentException("id cannot be null");
        if (name == null) throw new IllegalArgumentException("name cannot be null");
        this.id = id;
        this.name = name;
    }

    public UserId getId() {
        return id;
    }

    public UserName getName() {
        return name;
    }

    public void setName(UserName name) {
        if (name == null) throw new IllegalArgumentException("name cannot be null");
        this.name = name;
    }

    // 엔티티에 getter와 setter만 남기는 것은 안티패턴임을 기억하기.
    // 엔티티 자신을 변경하는 메소드는 엔티티 클래스가 가지는 것이 옳다.
    // 도메인 서비스는 엔티티 중복 검사와 같이 엔티티가 가지게 되면 어색한 것들만 가져야 한다.
    // 헷갈릴 땐 엔티티에 구현하고, 도메인 서비스는 최소화하기!
    public void changeName(UserName name) {
        if (name == null) throw new IllegalArgumentException("name cannot be null");
        this.name = name;
    }
}
