package com.woojoovove.ddd11.circle.domain;

import com.woojoovove.ddd11.user.domain.User;

import java.util.List;

public class Circle {
    private final CircleId id;
    private CircleName name;
    private User leader;
    private List<User> members;

    private Circle(CircleId id, CircleName name, User leader, List<User> members) {
        if (id == null) throw new IllegalArgumentException("id cannot be null");
        if (name == null) throw new IllegalArgumentException("name cannot be null");
        if (leader == null) throw new IllegalArgumentException("leader cannot be null");
        if (members == null) throw new IllegalArgumentException("members cannot be null");
        this.id = id;
        this.name = name;
        this.leader = leader;
        this.members = members;
    }

    public static final Circle create(CircleId id, CircleName name, User leader, List<User> members) {
        return new Circle(id, name, leader, members);
    }

    public static final Circle cloneCircle(Circle circle) {
        return Circle.create(circle.getId(), circle.getName(), circle.getLeader(), circle.getMembers());
    }

    public void addMember(User user) {
        if (this.members.size() >= 30) {
            throw new IllegalArgumentException("정원 초과");
        }
        this.members.add(user);
    }
    public CircleId getId() {
        return id;
    }

    public CircleName getName() {
        return name;
    }

    public User getLeader() {
        return leader;
    }

    public List<User> getMembers() {
        return members;
    }

}
