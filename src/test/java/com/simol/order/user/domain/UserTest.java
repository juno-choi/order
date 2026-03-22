package com.simol.order.user.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class UserTest {

    @Nested
    @DisplayName("User 생성")
    class CreateUser {
        @Test
        @DisplayName("성공한다")
        void ofSuccess1() {
            //given
            var name = "junho";

            //when
            var user = User.of(name, null);
            //then
            assertThat(user).isNotNull();
            assertThat(user.getName()).isEqualTo(name);
        }
    }

}