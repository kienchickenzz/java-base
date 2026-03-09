package com.example.apiServerBase.base.dto.request;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

/**
 * Base class cho request DTOs có pagination.
 *
 * <p>Page number bắt đầu từ 1 (user-friendly).
 * Tự động convert sang Spring Pageable (0-indexed) khi cần.
 */
@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
public class PaginatedRequest extends BaseRequest {

    @Min(value = 1, message = "Target page must be at least 1")
    @Builder.Default
    private int targetPage = 1;

    @Min(value = 1, message = "Page size must be at least 1")
    @Max(value = 100, message = "Page size cannot exceed 100")
    @Builder.Default
    private int pageSize = 10;

    /**
     * Convert sang Spring Pageable (0-indexed).
     *
     * @return Pageable instance cho Spring Data queries
     */
    public Pageable toPageable() {
        return PageRequest.of(targetPage - 1, pageSize);
    }

    /**
     * Tính skip offset cho raw queries.
     *
     * @return Số records cần skip
     */
    @JsonIgnore
    public int getOffset() {
        return (targetPage - 1) * pageSize;
    }
}
