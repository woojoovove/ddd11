# DDD

「도메인 주도 설계 철저 입문」11장 "애플리케이션 밑바닥부터 만들기"에 대한 Java 실습 프로젝트입니다.

![image](https://github.com/user-attachments/assets/29925c1c-d8ce-4cd8-8fed-20c72927ffa7)

## 폴더 구조
![image](https://github.com/user-attachments/assets/c6f0c80d-a42f-4e3d-bdf2-e065b641a6cb)

## 테스트 커버리지 100%
![image](https://github.com/user-attachments/assets/7ab6f637-0ff8-45e6-80d1-bd5681d794fc)

## 내용
- 객체 생성을 통제하기 위해 팩토리 패턴 및 정적 팩토리 메소드 사용
- 도메인 정보 수정은 도메인 클래스가 보유하기 (e.g. Circle의 멤버 변수 members는 private, 멤버 추가는 addMember()라는 메서드를 통해서만)
- 도메인이 다를 때 같은 레이어끼리 소통 (e.g. 서비스는 서비스, 인프라는 인프라 레이어끼리 소통)
- 테스트 시 의존 주입을 위한 인터페이스 구현 `IXXXFactory`, `IXXXRepository`
- `JUnit`을 활용한 단위 테스트
- `jacoco` 를 활용한 테스트 커버리지 측정
