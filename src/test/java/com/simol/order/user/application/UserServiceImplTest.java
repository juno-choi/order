package com.simol.order.user.application;

import com.simol.order.TestContainerConfiguration;
import com.simol.order.user.application.dto.request.CreateUserCommand;
import com.simol.order.user.infrastructure.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

import static org.assertj.core.api.Assertions.*;

@Import(TestContainerConfiguration.class)
@SpringBootTest
class UserServiceImplTest {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @BeforeEach
    void setUp() {
        userRepository.deleteAll();
    }

    @Nested
    @DisplayName("user 생성")
    class CreateUser {

        @Test
        @DisplayName("user 생성에 성공한다")
        void createUserSuccess1() {
            //given
            var name = new CreateUserCommand("홍길동");

            //when
            var userResult = userService.createUser(name);

            //then
            assertThat(userResult).isNotNull();
            assertThat(userResult.id()).isNotNull();
            assertThat(userResult.name()).isEqualTo(name.name());
        }
    }
}