package com.simol.order.product.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

class ProductTest {

    @Nested
    @DisplayName("Product 생성")
    class CreateProduct {

        @Test
        @DisplayName("이름, 가격, 재고를 전달하면 Product가 생성된다")
        void of_withAllFields_createsProduct() {
            // given
            final var name = "노트북";
            final var price = new BigDecimal("1500000");
            final var stock = 10L;

            // when
            final var product = Product.of(name, price, stock);

            // then
            assertThat(product).isNotNull();
            assertThat(product.getName()).isEqualTo(name);
            assertThat(product.getPrice()).isEqualByComparingTo(price);
            assertThat(product.getStock()).isEqualTo(stock);
        }

        @Test
        @DisplayName("새로 생성된 Product의 id는 null이다")
        void of_newProduct_idIsNull() {
            // given
            final var name = "마우스";
            final var price = new BigDecimal("30000");
            final var stock = 50L;

            // when
            final var product = Product.of(name, price, stock);

            // then
            assertThat(product.getId()).isNull();
        }

        @Test
        @DisplayName("가격이 0원이어도 Product가 생성된다")
        void of_withZeroPrice_createsProduct() {
            // given
            final var name = "무료 샘플";
            final var price = BigDecimal.ZERO;
            final var stock = 100L;

            // when
            final var product = Product.of(name, price, stock);

            // then
            assertThat(product).isNotNull();
            assertThat(product.getPrice()).isEqualByComparingTo(BigDecimal.ZERO);
        }

        @Test
        @DisplayName("재고가 0이어도 Product가 생성된다")
        void of_withZeroStock_createsProduct() {
            // given
            final var name = "품절 상품";
            final var price = new BigDecimal("10000");
            final var stock = 0L;

            // when
            final var product = Product.of(name, price, stock);

            // then
            assertThat(product).isNotNull();
            assertThat(product.getStock()).isEqualTo(0L);
        }

        @Test
        @DisplayName("소수점이 있는 가격으로도 Product가 생성된다")
        void of_withDecimalPrice_createsProduct() {
            // given
            final var name = "커피";
            final var price = new BigDecimal("4500.50");
            final var stock = 200L;

            // when
            final var product = Product.of(name, price, stock);

            // then
            assertThat(product).isNotNull();
            assertThat(product.getPrice()).isEqualByComparingTo(new BigDecimal("4500.50"));
        }

        @Test
        @DisplayName("매우 큰 가격 값으로도 Product가 생성된다")
        void of_withLargePrice_createsProduct() {
            // given
            final var name = "슈퍼카";
            final var largePrice = new BigDecimal("999999999999.99");
            final var stock = 1L;

            // when
            final var product = Product.of(name, largePrice, stock);

            // then
            assertThat(product).isNotNull();
            assertThat(product.getPrice()).isEqualByComparingTo(largePrice);
        }

        @Test
        @DisplayName("매우 큰 재고 값으로도 Product가 생성된다")
        void of_withLargeStock_createsProduct() {
            // given
            final var name = "볼펜";
            final var price = new BigDecimal("500");
            final var largeStock = Long.MAX_VALUE;

            // when
            final var product = Product.of(name, price, largeStock);

            // then
            assertThat(product).isNotNull();
            assertThat(product.getStock()).isEqualTo(Long.MAX_VALUE);
        }

        @Test
        @DisplayName("이름이 다른 두 Product는 서로 다른 객체다")
        void of_twoProductsWithDifferentNames_areDistinctObjects() {
            // given
            final var price = new BigDecimal("10000");
            final var stock = 5L;

            // when
            final var product1 = Product.of("키보드", price, stock);
            final var product2 = Product.of("마우스", price, stock);

            // then
            assertThat(product1).isNotSameAs(product2);
            assertThat(product1.getName()).isNotEqualTo(product2.getName());
        }

        @Test
        @DisplayName("동일한 인자로 생성한 두 Product는 별개의 인스턴스다")
        void of_sameArguments_producesDistinctInstances() {
            // given
            final var name = "이어폰";
            final var price = new BigDecimal("50000");
            final var stock = 30L;

            // when
            final var product1 = Product.of(name, price, stock);
            final var product2 = Product.of(name, price, stock);

            // then
            // Domain objects are not value objects; each call produces a new instance
            assertThat(product1).isNotSameAs(product2);
        }

        @Test
        @DisplayName("name이 null이어도 Product가 생성된다 (도메인 검증 없음, DB 제약에 위임)")
        void of_withNullName_createsProductWithoutDomainGuard() {
            // given
            // DB-level: @Column(nullable = false) — caught at persistence time, not domain time
            final var price = new BigDecimal("10000");
            final var stock = 5L;

            // when
            final var product = Product.of(null, price, stock);

            // then
            assertThat(product).isNotNull();
            assertThat(product.getName()).isNull();
        }

        @Test
        @DisplayName("price가 null이어도 Product가 생성된다 (도메인 검증 없음, DB 제약에 위임)")
        void of_withNullPrice_createsProductWithoutDomainGuard() {
            // given
            // DB-level: @Column(nullable = false) — caught at persistence time, not domain time
            final var name = "테스트 상품";
            final var stock = 5L;

            // when
            final var product = Product.of(name, null, stock);

            // then
            assertThat(product).isNotNull();
            assertThat(product.getPrice()).isNull();
        }

        @Test
        @DisplayName("stock이 null이어도 Product가 생성된다 (도메인 검증 없음, DB 제약에 위임)")
        void of_withNullStock_createsProductWithoutDomainGuard() {
            // given
            // DB-level: @Column(nullable = false) — caught at persistence time, not domain time
            final var name = "테스트 상품";
            final var price = new BigDecimal("10000");

            // when
            final var product = Product.of(name, price, null);

            // then
            assertThat(product).isNotNull();
            assertThat(product.getStock()).isNull();
        }
    }
}
