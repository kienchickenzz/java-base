package com.example.apiServerBase.health.dto;

import com.example.apiServerBase.base.dto.request.BaseRequest;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
public class HealthRequest extends BaseRequest {
    // Health entity không có fields riêng ngoài BaseEntity
}
