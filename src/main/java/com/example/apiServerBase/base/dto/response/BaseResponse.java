package com.example.apiServerBase.base.dto.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

/**
 * Base class cho tất cả response DTOs.
 */
@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
public abstract class BaseResponse {
    // Marker class - các response DTO sẽ extends class này
}
