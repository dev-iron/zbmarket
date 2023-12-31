package com.example.zbmarket.service.product.model;

import com.example.zbmarket.repository.entity.ProductEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class ProductFound {
    private Long id;
    private String name;
    private Long stock;
    private Long price;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public static ProductFound from(ProductEntity product) {
        return ProductFound.builder()
                .id(product.getId())
                .name(product.getName())
                .stock(product.getStock())
                .price(product.getPrice())
                .createdAt(product.getCreatedAt())
                .updatedAt(product.getUpdatedAt())
                .build();
    }
}
