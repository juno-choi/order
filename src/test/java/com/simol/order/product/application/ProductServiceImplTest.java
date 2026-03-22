package com.simol.order.product.application;

import com.simol.order.TestContainerConfiguration;
import com.simol.order.product.application.dto.request.CreateProductCommand;
import com.simol.order.product.infrastructure.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

@Import(TestContainerConfiguration.class)
@SpringBootTest
class ProductServiceImplTest {

    @Autowired
    private ProductService productService;

    @Autowired
    private ProductRepository productRepository;

    @BeforeEach
    void setUp() {
        productRepository.deleteAll();
    }

    @Nested
    @DisplayName("상품 생성")
    class CreateProduct {

        @Test
        @DisplayName("상품 생성에 성공한다")
        void createProductSuccess() {
            // given
            var command = CreateProductCommand.of("테스트 상품", BigDecimal.valueOf(10000), 100L);

            // when
            var result = productService.createProduct(command);

            // then
            assertThat(result).isNotNull();
            assertThat(result.id()).isNotNull();
            assertThat(result.name()).isEqualTo(command.name());
            assertThat(result.price()).isEqualByComparingTo(command.price());
            assertThat(result.stock()).isEqualTo(command.stock());
        }
    }
}
