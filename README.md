# jwp-racingcar

# 페어 프로그래밍 룰

## 스위치 기준

- [x] 스위치 시간은 20분으로 한다.
- [x] 내비게이터는 전자기기에 손을 대지 않는다.

## 깃 컨벤션

- [x] 기능 목록에 있는 기능 단위로 커밋한다.
- [x] 작동할 수 있는 기능 단위로 커밋한다.
- [x] 커밋 메세지는 아래 키워드를 사용해 기능 목록 그대로 작성한다.
    - feat: 기능 구현을 완료했을 때
    - refactor: 기능의 변화 없이 코드를 변경했을 때
    - test: 테스트 코드만 작성했을 때
    - chore: 패키지 변경 등 사소한 수정사항이 생겼을 때
    - fix: 프로그램의 결함을 수정할 때
    - docs: 문서를 수정할 때

## 코드 컨벤션

- [x] 모든 클래스는 `final` 혹은 `abstract` 이어야 한다.
- [x] 모든 파라미터에 `final` 키워드를 붙인다.

## 구현 계획

- [x] 구현은 다음과 같은 순서로 진행된다.
    1. Spring MVC 학습
    2. 자동차 경주 미션 - 웹 요청/응답 구현하기
    3. Spring JDBC 학습
    4. 자동차 경주 미션 - DB 연동하기
    5. 리팩토링

## 기타 룰

- [x] 미션 진행 2일차(수) 오후 4:00에 중간 회고를 진행한다.
- [x] 최소한 2시간에 한 번은 쉬어야 한다.
- [x] 커피챗을 최소 1회 진행한다.
- [x] 집중이 안된다면 페어에게 솔직하게 이야기한다.

---

# 추가로 구현할 기능 목록

- [x] 자동차 경주 진행에 대한 웹 API를 구현한다.
    - [x] 자동차 경주 진행에 대한 웹 요청을 받을 수 있다.
        - [x] JSON 형태로 입력을 받는다.
            - [x] 참여자들의 이름을 입력받는다.
            - [x] 시도 횟수를 입력받는다.
        - [x] `/plays`로 `POST` 요청을 보낼 시 응답한다.
    - [x] 자동차 경주 진행 결과에 대한 웹 응답을 전달할 수 있다.
        - [x] JSON 형태로 전달한다.
            - [x] 우승자들의 이름을 전달한다.
            - [x] 참여자들의 정보를 전달한다.
                - [x] 모든 참여자들의 이름을 전달한다.
                - [x] 모든 참여자들의 이동 거리를 전달한다.
        - [x] 성공 시 STATUS CODE `200`를 반환한다.
        - [x] 실패 시 다음과 같은 STATUS CODE를 반환한다.
            - [x] 사용자 입력이 잘못되었을 때는 `400`을 반환한다.
            - [x] 정의되지 않은 경로로 요청하는 경우 `404`를 반환한다.
            - [x] 정의되지 않은 HTTP 메서드를 호출했을 때는 `405`를 반환한다.
            - [x] 서버 내부에서 에러가 발생했을 때는 `500`을 반환한다.

# TO-STUDY

- [ ] `@Transactional` 학습, 어떻게 사용할 수 있는지
- [ ] Mock 테스트의 테스트 범위와 원리 학습하기
- [ ] RequestBody + Model 같이 사용할 수 있는지
- [ ] RequestBody의 required가 어떻게 동작하는지

# 고민사항

- [ ] 이너클래스로 `CarDTO`를 둘지, 외부 객체로 뺼지