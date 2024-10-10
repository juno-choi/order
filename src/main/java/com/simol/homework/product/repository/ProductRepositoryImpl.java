package com.simol.homework.product.repository;

import com.simol.homework.product.model.Product;

import java.util.*;

public class ProductRepositoryImpl implements ProductRepository, ProductRepositoryInit{
    private final Map<Long, Product> productMap;

    public ProductRepositoryImpl() {
        this.productMap = init();
    }

    @Override
    public Map<Long, Product> init() {
        Map<Long, Product> productMap = new HashMap<>();
        productMap.put(768848L, Product.of(768848L, "[STANLEY] GO CERAMIVAC 진공 텀블러/보틀 3종", 21000, 45));
        productMap.put(748943L, Product.of(748943L, "디오디너리 데일리 세트 (Daily set)", 19000, 89));
        productMap.put(779989L, Product.of(779989L, "버드와이저 HOME DJing 굿즈 세트", 35000, 43));
        productMap.put(779943L, Product.of(779943L, "Fabrik Pottery Flat Cup & Saucer - Mint", 24900, 89));
        productMap.put(768110L, Product.of(768110L, "네페라 손 세정제 대용량 500ml 이더블유지", 7000, 79));
        productMap.put(517643L, Product.of(517643L, "에어팟프로 AirPods PRO 블루투스 이어폰(MWP22KH/A)", 260800, 26));
        productMap.put(706803L, Product.of(706803L, "ZEROVITY™ Flip Flop Cream 2.0 (Z-FF-CRAJ-)", 38000, 81));
        productMap.put(759928L, Product.of(759928L, "마스크 스트랩 분실방지 오염방지 목걸이", 2800, 85));
        productMap.put(213341L, Product.of(213341L, "20SS 오픈 카라/투 버튼 피케 티셔츠 (6color)", 33250, 99));
        productMap.put(377169L, Product.of(377169L, "[29Edition.]_[스페셜구성] 뉴코튼베이직 브라렛 세트 (브라1+팬티2)", 24900, 60));
        productMap.put(744775L, Product.of(744775L, "SHUT UP [TK00112]", 28000, 35));
        productMap.put(779049L, Product.of(779049L, "[리퍼브/키친마켓] Fabrik Pottery Cup, Saucer (단품)", 10000, 64));
        productMap.put(611019L, Product.of(611019L, "플루크 new 피그먼트 오버핏 반팔티셔츠 FST701 / 7color M", 19800, 7));
        productMap.put(628066L, Product.of(628066L, "무설탕 프로틴 초콜릿 틴볼스", 12900, 8));
        productMap.put(502480L, Product.of(502480L, "[29Edition.]_[스페셜구성] 렉시 브라렛 세트(브라1+팬티2)", 24900, 41));
        productMap.put(782858L, Product.of(782858L, "폴로 랄프로렌 남성 수영복반바지 컬렉션 (51color)", 39500, 50));
        productMap.put(760709L, Product.of(760709L, "파버카스텔 연필1자루", 200, 70));
        productMap.put(778422L, Product.of(778422L, "캠핑덕 우드롤테이블", 45000, 7));
        productMap.put(648418L, Product.of(648418L, "BS 02-2A DAYPACK 26 (BLACK)", 238000, 5));
        return productMap;
    }

    @Override
    public List<Product> findAllOrderByProductIdDesc() {
        List<Product> list = new ArrayList<>(productMap.values());
        return Collections.unmodifiableList(list);
    }
}
