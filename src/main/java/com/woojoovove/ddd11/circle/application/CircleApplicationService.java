package com.woojoovove.ddd11.circle.application;


import com.woojoovove.ddd11.circle.application.create.CircleCreateCommand;
import com.woojoovove.ddd11.circle.application.join.CircleJoinCommand;
import com.woojoovove.ddd11.circle.domain.Circle;
import com.woojoovove.ddd11.circle.domain.CircleName;
import com.woojoovove.ddd11.circle.domain.ICircleFactory;
import com.woojoovove.ddd11.circle.infrastructure.ICircleRepository;
import com.woojoovove.ddd11.user.application.UserApplicationService;
import com.woojoovove.ddd11.user.domain.User;

public class CircleApplicationService {
    private final ICircleRepository circleRepository;
    private final ICircleFactory circleFactory;
    private final UserApplicationService userApplicationService;

    public CircleApplicationService(ICircleRepository circleRepository, ICircleFactory circleFactory, UserApplicationService userApplicationService) {
        this.circleRepository = circleRepository;
        this.circleFactory = circleFactory;
        this.userApplicationService = userApplicationService;
    }

    public void createCircle(CircleCreateCommand createCommand) {
        // CircleAppService가 UserRepository에 직접 의존하지 않도록 함.
        User user = userApplicationService.findOrNull(createCommand.getOwnerId());
        // Q. 에러가 뷰 레이어에서 처리되었어야 하는 건 아닌가? 받자마자...
        // 그러나 뷰 레이어는 DB 접근 등의 책임에서 자유로워야 하므로
        // user 존재 여부는 서비스 레이어에서 검사하기로 함.
        if (user == null) throw new IllegalArgumentException("user not found");
        if (circleExists(createCommand.getName())) throw new IllegalArgumentException("circle already exists");
        Circle circle = circleFactory.create(createCommand.getName(), user);
        circleRepository.save(circle);
    }

    // Entity가 이미 Repository에 존재하는지 확인하는 기능은
    // 도메인 서비스일까 아니면 앱 서비스일까?
    // 도메인 주도 설계 철처 입문 저자는 도메인 서비스라고 하지만,
    // 도메인 서비스가 Repository에 직접 의존하지 않아야
    // 순수한 도메인일 수 있을 것 같아서
    // 앱 서비스로 구현한다.
    public boolean circleExists(CircleName circleName) {
        return circleRepository.findByNameOrNull(circleName) != null;
    }

    public void joinCircle(final CircleJoinCommand joinCommand) {
        Circle circle = circleRepository.findByIdOrNull(joinCommand.getCircleId());
        if (circle == null) throw new IllegalArgumentException("circle not found");
        User user = userApplicationService.findOrNull(joinCommand.getUserId());
        if (user == null) throw new IllegalArgumentException("user not found");
        circle.addMember(user);
        circleRepository.save(circle);
    }
}
