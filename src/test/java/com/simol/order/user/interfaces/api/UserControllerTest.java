package com.simol.order.user.interfaces.api;

import com.simol.order.user.application.UserService;
import com.simol.order.user.application.dto.request.CreateUserCommand;
import com.simol.order.user.application.dto.response.UserResult;
import com.simol.order.user.domain.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(UserController.class)
class UserControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private UserService userService;

    @Nested
    @DisplayName("POST /users - 유저 생성")
    class CreateUser {
        @Test
        @DisplayName("body가 비어있으면 실패한다")
        void createUserFail1() throws Exception {
            //given
            //when
            var resultActions = mockMvc.perform(
                post("/api/v1/users")
                    .contentType(MediaType.APPLICATION_JSON)
            ).andDo(print());

            //then
            resultActions
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.code").value("BAD_REQUEST"))
                .andExpect(jsonPath("$.message").isNotEmpty());
        }

        @Test
        @DisplayName("요청 name이 없으면 유저 등록에 실패한다")
        void createUserFail2() throws Exception {
            //given
            var requestBody = """
                {}
                """;
            //when
            var resultActions = mockMvc.perform(
                post("/api/v1/users")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(requestBody)
            ).andDo(print());

            //then
            resultActions
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.code").value("BAD_REQUEST"))
                .andExpect(jsonPath("$.message").isNotEmpty());
        }

        @Test
        @DisplayName("요청에 성공한다")
        void createUserSuccess1() throws Exception{
            //given
            var name = "junho";
            var requestBody = """
                {
                    "name" : "%s"
                }
                """.formatted(name);

            var user = User.of(name, null);
            given(userService.createUser(any(CreateUserCommand.class)))
                .willReturn(new UserResult(1L, name));

            //when
            var resultActions = mockMvc.perform(
                post("/api/v1/users")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(requestBody)
            ).andDo(print());

            //then
            resultActions
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("$.id").isNotEmpty())
                .andExpect(jsonPath("$.name").value(name));
        }
    }

}