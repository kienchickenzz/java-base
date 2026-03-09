package com.example.apiServerBase.base.dto.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

/**
 * Base class cho tất cả request DTOs.
 *
 * <p>Cấu hình:
 * <ul>
 *   <li>ignoreUnknown = false: Reject unknown fields (như extra='forbid' trong Python)</li>
 *   <li>SuperBuilder: Cho phép builder pattern với inheritance</li>
 * </ul>
 */
@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
@JsonIgnoreProperties(ignoreUnknown = false)
public abstract class BaseRequest {
    // Marker class - các request DTO sẽ extends class này
}
