package com.simol.order.user.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.*;

class UserTest {

    @Nested
    @DisplayName("User 생성")
    class CreateUser {

        @Test
        @DisplayName("이름만 전달하면 User가 생성된다")
        void ofSuccess1() {
            // given
            final var name = "junho";

            // when
            final var user = User.of(name, null);

            // then
            assertThat(user).isNotNull();
            assertThat(user.getName()).isEqualTo(name);
        }

        @Test
        @DisplayName("이름과 잔액을 전달하면 User가 생성되고 값이 정확히 설정된다")
        void of_withNameAndBalance_setsFieldsCorrectly() {
            // given
            final var name = "junho";
            final var balance = new BigDecimal("10000");

            // when
            final var user = User.of(name, balance);

            // then
            assertThat(user).isNotNull();
            assertThat(user.getName()).isEqualTo(name);
            assertThat(user.getBalance()).isEqualByComparingTo(balance);
        }

        @Test
        @DisplayName("잔액이 0원이어도 User가 생성된다")
        void of_withZeroBalance_createsUser() {
            // given
            final var name = "junho";
            final var balance = BigDecimal.ZERO;

            // when
            final var user = User.of(name, balance);

            // then
            assertThat(user).isNotNull();
            assertThat(user.getBalance()).isEqualByComparingTo(BigDecimal.ZERO);
        }

        @Test
        @DisplayName("매우 큰 잔액 값으로도 User가 생성된다")
        void of_withLargeBalance_createsUser() {
            // given
            final var name = "junho";
            final var largeBalance = new BigDecimal("999999999999999999.99");

            // when
            final var user = User.of(name, largeBalance);

            // then
            assertThat(user).isNotNull();
            assertThat(user.getBalance()).isEqualByComparingTo(largeBalance);
        }

        @Test
        @DisplayName("소수점이 있는 잔액으로도 User가 생성된다")
        void of_withDecimalBalance_createsUser() {
            // given
            final var name = "junho";
            final var balance = new BigDecimal("1234.56");

            // when
            final var user = User.of(name, balance);

            // then
            assertThat(user).isNotNull();
            assertThat(user.getBalance()).isEqualByComparingTo(new BigDecimal("1234.56"));
        }

        @Test
        @DisplayName("새로 생성된 User의 id는 null이다")
        void of_newUser_idIsNull() {
            // given
            final var name = "junho";
            final var balance = new BigDecimal("5000");

            // when
            final var user = User.of(name, balance);

            // then
            assertThat(user.getId()).isNull();
        }

        @Test
        @DisplayName("이름이 다른 두 User는 서로 다른 객체다")
        void of_twoUsersWithDifferentNames_areDistinctObjects() {
            // given
            final var balance = new BigDecimal("1000");

            // when
            final var user1 = User.of("junho", balance);
            final var user2 = User.of("gildong", balance);

            // then
            assertThat(user1).isNotSameAs(user2);
            assertThat(user1.getName()).isNotEqualTo(user2.getName());
        }
    }
}
