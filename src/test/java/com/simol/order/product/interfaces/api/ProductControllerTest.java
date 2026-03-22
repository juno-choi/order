package com.simol.order.product.interfaces.api;

import com.simol.order.product.application.ProductService;
import com.simol.order.product.application.dto.request.CreateProductCommand;
import com.simol.order.product.application.dto.response.ProductResult;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ProductController.class)
class ProductControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private ProductService productService;

    @Nested
    @DisplayName("POST /api/v1/products - 상품 생성")
    class CreateProduct {

        @Test
        @DisplayName("body가 비어있으면 실패한다")
        void createProductFail1() throws Exception {
            //given
            //when
            var resultActions = mockMvc.perform(
                post("/api/v1/products")
                    .contentType(MediaType.APPLICATION_JSON)
            ).andDo(print());

            //then
            resultActions
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.code").value("BAD_REQUEST"))
                .andExpect(jsonPath("$.message").isNotEmpty());
        }

        @Test
        @DisplayName("요청 name이 없으면 상품 등록에 실패한다")
        void createProductFail2() throws Exception {
            //given
            var requestBody = """
                {
                    "price": 10000,
                    "stock": 100
                }
                """;

            //when
            var resultActions = mockMvc.perform(
                post("/api/v1/products")
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
        @DisplayName("요청 price가 없으면 상품 등록에 실패한다")
        void createProductFail3() throws Exception {
            //given
            var requestBody = """
                {
                    "name": "상품A",
                    "stock": 100
                }
                """;

            //when
            var resultActions = mockMvc.perform(
                post("/api/v1/products")
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
        @DisplayName("요청 stock이 없으면 상품 등록에 실패한다")
        void createProductFail4() throws Exception {
            //given
            var requestBody = """
                {
                    "name": "상품A",
                    "price": 10000
                }
                """;

            //when
            var resultActions = mockMvc.perform(
                post("/api/v1/products")
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
        void createProductSuccess1() throws Exception {
            //given
            var name = "상품A";
            var price = new BigDecimal("10000");
            var stock = 100L;
            var requestBody = """
                {
                    "name": "%s",
                    "price": %s,
                    "stock": %d
                }
                """.formatted(name, price, stock);

            given(productService.createProduct(any(CreateProductCommand.class)))
                .willReturn(new ProductResult(1L, name, price, stock));

            //when
            var resultActions = mockMvc.perform(
                post("/api/v1/products")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(requestBody)
            ).andDo(print());

            //then
            resultActions
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("$.id").isNotEmpty())
                .andExpect(jsonPath("$.name").value(name))
                .andExpect(jsonPath("$.price").value(price))
                .andExpect(jsonPath("$.stock").value(stock));
        }
    }
}
