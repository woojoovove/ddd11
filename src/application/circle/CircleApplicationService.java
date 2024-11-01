package application.circle;

import application.circle.create.CircleCreateCommand;
import application.circle.join.CircleJoinCommand;
import application.user.UserApplicationService;
import domain.circle.*;
import domain.user.IUserRepository;
import domain.user.User;

import java.util.List;

public class CircleApplicationService {
    private final ICircleRepository circleRepository;
    private final ICircleFactory circleFactory;
    private final UserApplicationService userApplicationService;

    public CircleApplicationService(ICircleRepository circleRepository, ICircleFactory circleFactory, IUserRepository userRepository, UserApplicationService userApplicationService) {
        this.circleRepository = circleRepository;
        this.circleFactory = circleFactory;
        this.userApplicationService = userApplicationService;
    }


    public void createCircle(CircleCreateCommand createCommand) {
        // CircleAppService가 UserRepository에 직접 의존하지 않도록 함.
        User user = userApplicationService.findOrNull(createCommand.getOwnerId());
        // TODO: 에러가 뷰 레이어에서 처리되었어야 하는 건 아닌가? 받자마자...
        if (user == null) throw new IllegalArgumentException("no circle leader");
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

    public void joinCircle(CircleJoinCommand joinCommand) {
        Circle circle = circleRepository.findByIdOrNull(joinCommand.getCircleId());
        if (circle == null) throw new IllegalArgumentException("circle not found");
        User user = userApplicationService.findOrNull(joinCommand.getUserId());
        if (user == null) throw new IllegalArgumentException("user not found");
        List<User> member = circle.getMembers();
        if (member.size()>29) {
            throw new IllegalStateException("정원 초과");
        }
        member.add(user);
        circleRepository.save(circle);
    }
}
