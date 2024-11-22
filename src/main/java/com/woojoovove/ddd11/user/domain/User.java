package com.woojoovove.ddd11.user.domain;

public class User {
    private final UserId id;
    private UserName name;

    // 객체 생성을 통제하기 위해 팩토리 패턴으로 User를 생성하도록 결정
    // 이때 생성자를 아예 만들지 않으면 자바 컴파일러는 자동으로 기본 생성자*를 생성하여
    // 아무나 기본 생성자를 통해 User를 생성할 수 있게 됨.
    // 따라서 생성자를 반드시 만들고, private으로 설정하는 것이 바람직함.
    // * 기본 생성자는 매개변수가 없는 생성자로 필드를 null로 초기화함.
    private User(UserId id, UserName name) {
        if (id == null) throw new IllegalArgumentException("id cannot be null");
        if (name == null) throw new IllegalArgumentException("name cannot be null");
        this.id = id;
        this.name = name;
    }

    // 정적 팩토리 메소드
    // static : 인스턴스가 없을 때도 이 메소드를 호출할 수 있게 한다.
    // final : 객체를 immutable 하게 관리한다.
    // public : 외부 레이어(infrastructre/**)가 도메인 레이어(domian/**)에 의존할 수밖에 없음.
    public static final User create(UserId id, UserName name) {
        return new User(id, name);
    }

    // Getters
    public UserId getId() {
        return id;
    }

    public UserName getName() {
        return name;
    }

    // 엔티티에 getter와 setter만 남기는 것은 안티패턴임을 기억하기.
    // 엔티티 자신을 변경하는 메소드는 엔티티 클래스가 가지는 것이 옳다.
    // 도메인 서비스는 엔티티 중복 검사와 같이 엔티티가 가지게 되면 어색한 것들만 가져야 한다.
    // 헷갈릴 땐 엔티티에 구현하고, 도메인 서비스는 최소화하기!
    public void changeName(UserName name) {
        if (name == null) throw new IllegalArgumentException("name cannot be null");
        this.name = name;
    }

    public static User cloneUser(User user) {
        return create(user.getId(), user.getName());
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return true;
        User user = (User) obj;
        return id.equals(user.getId());
    }

}
