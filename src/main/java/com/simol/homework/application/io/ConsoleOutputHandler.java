package com.simol.homework.application.io;

import com.simol.homework.cart.model.OrderInfo;
import com.simol.homework.product.model.Product;

import java.util.List;

public class ConsoleOutputHandler implements OutputHandler {
    @Override
    public void userInputOrder() {
        System.out.print("입력(o[order] 주문, q[quite] 종료) : ");
    }

    @Override
    public void orderEnd() {
        System.out.println("고객님의 주문 감사합니다.");
    }

    @Override
    public void printProductList(List<Product> productList) {
        System.out.println("상품번호\t\t상품명\t\t\t\t\t\t\t판매가격\t\t재고수");
        for (Product p : productList) {
            String printString = "%s\t\t%s\t%d\t%d"
                    .formatted(p.getProductId(), p.getProductName(), p.getProductPrice(), p.getProductStock());
            System.out.println(printString);
        }
    }

    @Override
    public void inputProductId() {
        System.out.print("상품번호 : ");
    }

    @Override
    public void inputQuantity() {
        System.out.print("수량 : ");
    }

    @Override
    public void invalidProductId() {
        System.out.println("상품번호를 확인해주세요.");
    }

    @Override
    public void printOrderInfo(List<OrderInfo> orderList) {
        System.out.println("주문 내역:");
        System.out.println("----------------------------------");
        for (OrderInfo o : orderList) {
            String printString = "%s - %s개".formatted(o.getProductName(), o.getQuantity());
            System.out.println(printString);
        }
        System.out.println("----------------------------------");
    }
}
