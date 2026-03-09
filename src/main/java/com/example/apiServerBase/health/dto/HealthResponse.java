package com.example.apiServerBase.health.dto;

import com.example.apiServerBase.base.dto.response.BaseResponse;
import com.example.apiServerBase.health.entity.Health;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
public class HealthResponse extends BaseResponse {

    private Long id;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public static HealthResponse from(Health entity) {
        return HealthResponse.builder()
                .id(entity.getId())
                .createdAt(entity.getCreatedAt())
                .updatedAt(entity.getUpdatedAt())
                .build();
    }
}
