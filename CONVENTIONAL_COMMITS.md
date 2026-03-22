# Conventional Commits

## 개요

Conventional Commits는 커밋 메시지에 일관된 규칙을 부여하는 명세(Specification)이다.
커밋 히스토리를 읽기 쉽게 만들고, 자동화 도구(릴리즈 노트 생성, 버전 관리 등)와의 연동을 가능하게 한다.

## 커밋 메시지 구조

```
<type>[optional scope]: <description>

[optional body]

[optional footer(s)]
```

### 각 요소 설명

| 요소 | 필수 여부 | 설명 |
|------|----------|------|
| `type` | 필수 | 커밋의 종류를 나타내는 접두사 |
| `scope` | 선택 | 변경 범위를 나타내는 괄호 안의 명사 (예: `feat(user):`) |
| `description` | 필수 | 변경 사항을 간결하게 설명하는 제목 |
| `body` | 선택 | 변경의 동기나 상세 내용을 설명하는 본문 |
| `footer` | 선택 | Breaking Change 고지 또는 이슈 참조 등 |

## 타입(Type) 목록

### 필수 타입

| 타입 | 설명 | 예시 |
|------|------|------|
| `feat` | 새로운 기능 추가 | `feat: User 생성 기능 추가` |
| `fix` | 버그 수정 | `fix: 잔액 차감 시 음수 허용 버그 수정` |

### 권장 타입

| 타입 | 설명 | 예시 |
|------|------|------|
| `chore` | 빌드, 설정, 문서 등 비기능 변경 | `chore: CLAUDE.md 수정` |
| `refactor` | 리팩토링 (기능 변경 없음) | `refactor: UserService 메서드 분리` |
| `test` | 테스트 코드 추가/수정 | `test: UserService 단위 테스트 추가` |
| `docs` | 문서만 변경 | `docs: README 업데이트` |
| `style` | 코드 의미에 영향 없는 변경 (포맷팅, 세미콜론 등) | `style: 불필요한 import 제거` |
| `perf` | 성능 개선 | `perf: 사용자 조회 쿼리 최적화` |
| `ci` | CI/CD 설정 변경 | `ci: GitHub Actions 워크플로우 추가` |

## Breaking Change (호환성 깨짐)

API나 동작이 기존과 호환되지 않는 변경이 있을 때 표기한다.

**방법 1**: 타입 뒤에 `!` 추가
```
feat!: 사용자 API 응답 구조 변경
```

**방법 2**: footer에 `BREAKING CHANGE:` 작성
```
feat: 사용자 API 응답 구조 변경

BREAKING CHANGE: UserResponse의 balance 필드가 Long에서 BigDecimal로 변경됨
```

## 핵심 규칙 요약

1. `feat`은 SemVer의 MINOR 버전에 대응한다 (0.1.0 → 0.2.0)
2. `fix`는 SemVer의 PATCH 버전에 대응한다 (0.1.0 → 0.1.1)
3. `BREAKING CHANGE`는 MAJOR 버전에 대응한다 (0.1.0 → 1.0.0)
4. `type` 외의 요소(scope, body, footer)는 모두 선택사항이다
5. 커밋 메시지의 `description`은 `type:` 바로 뒤 공백 다음에 작성한다
