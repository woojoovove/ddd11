package com.woojoovove.ddd11.circle.domain;

import com.woojoovove.ddd11.user.domain.User;

public interface ICircleFactory {
    Circle create(CircleName name, User owner);
}
