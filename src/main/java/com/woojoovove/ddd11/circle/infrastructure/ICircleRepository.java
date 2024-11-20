package com.woojoovove.ddd11.circle.infrastructure;

import com.woojoovove.ddd11.circle.domain.Circle;
import com.woojoovove.ddd11.circle.domain.CircleId;
import com.woojoovove.ddd11.circle.domain.CircleName;

public interface ICircleRepository {
    Circle findByNameOrNull(CircleName circleName);
    Circle findByIdOrNull(CircleId circleId);

    void save(Circle circle);
}
