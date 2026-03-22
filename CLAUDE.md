# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Project Overview

주문(Order) 도메인을 다루는 Spring Boot 애플리케이션. Spring Modulith 기반의 모듈형 모놀리스 아키텍처를 사용한다.

## Tech Stack

- Java 17, Spring Boot 3.5.x, Gradle 8.14
- Spring Modulith 1.4.x (모듈 간 경계 및 이벤트 기반 통신)
- Spring Data JPA (persistence)
- Lombok
- JUnit 5 (testing)

## Build & Test Commands

```bash
./gradlew build          # 빌드 + 테스트
./gradlew test           # 전체 테스트
./gradlew test --tests "com.simol.order.user.*"  # 특정 모듈 테스트
./gradlew test --tests "com.simol.order.user.domain.UserTest"  # 단일 테스트 클래스
./gradlew bootRun        # 애플리케이션 실행
```

## Architecture

Spring Modulith 구조로, 각 도메인 모듈은 `com.simol.order.<module>` 패키지 아래에 위치한다.

### 모듈 내부 구조 (DDD 레이어)

각 모듈은 DDD 원칙에 따라 다음 레이어로 구성한다:
- `domain/` — 엔티티, 값 객체, 도메인 서비스. 도메인은 자신의 역할만 수행한다.
- `application/` — 유스케이스 오케스트레이션 (서비스 계층)
- `infrastructure/` — Repository 구현, 외부 시스템 연동
- `presentation/` — Controller, DTO

### 현재 모듈

- `user` — 사용자 도메인 (잔액 관리 포함)

## Code Conventions (REVIEW.md)

- [review 파일](REVIEW.md) 참고

### 엔티티 패턴

- 생성자는 `protected`로 제한 (`@NoArgsConstructor(access = AccessLevel.PROTECTED)`)
- Builder는 `private`으로 제한 (`@Builder(access = AccessLevel.PRIVATE)`)
- 정적 팩토리 메서드(`of`, `create` 등)를 통해서만 생성
- `@Getter` 사용, Setter는 사용하지 않음 — 상태 변경은 도메인 메서드를 통해서만
