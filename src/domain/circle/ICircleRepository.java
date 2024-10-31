package domain.circle;

public interface ICircleRepository {
    Circle findByNameOrNull(CircleName circleName);
}
