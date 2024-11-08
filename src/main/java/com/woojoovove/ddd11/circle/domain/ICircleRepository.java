package circle.domain;

public interface ICircleRepository {
    Circle findByNameOrNull(CircleName circleName);
    Circle findByIdOrNull(CircleId circleId);

    void save(Circle circle);
}
