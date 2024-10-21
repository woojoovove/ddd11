package domain.circle;

import domain.user.User;

import java.util.List;

public class Circle {
    private final CircleId id;
    private CircleName name;
    private User leader;
    private List<User> members;

    public Circle(CircleId id, CircleName name, User leader, List<User> members) {
        if (id == null) throw new IllegalArgumentException("id cannot be null");
        if (name == null) throw new IllegalArgumentException("name cannot be null");
        if (leader == null) throw new IllegalArgumentException("leader cannot be null");
        if (members == null) throw new IllegalArgumentException("members cannot be null");
        this.id = id;
        this.name = name;
        this.leader = leader;
        this.members = members;
    }

    public CircleId getId() {
        return id;
    }

    public CircleName getName() {
        return name;
    }

    public void setName(CircleName name) {
        if (name == null) throw new IllegalArgumentException("name cannot be null");
        this.name = name;
    }

    public User getLeader() {
        return leader;
    }

    public void setLeader(User leader) {
        if (leader == null) throw new IllegalArgumentException("leader cannot be null");
        this.leader = leader;
    }

    public List<User> getMembers() {
        return members;
    }

    public void setMembers(List<User> members) {
        if (members == null) throw new IllegalArgumentException("members cannot be null");
        this.members = members;
    }
}
