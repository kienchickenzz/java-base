package com.example.apiServerBase.base.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.function.Function;

/**
 * Generic wrapper cho paginated responses.
 *
 * <p>Tương đương với Python PaginatedResponseBase trong main.py
 *
 * @param <T> Kiểu dữ liệu của items trong list
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PaginatedResponse<T> {

    private List<T> items;
    private int currentPage;    // 1-indexed (user-friendly)
    private int totalPages;
    private int pageSize;
    private long totalItems;

    /**
     * Tạo PaginatedResponse từ Spring Page.
     * Convert page number từ 0-indexed sang 1-indexed.
     *
     * @param page Spring Page chứa data
     * @param <T>  Kiểu dữ liệu của items
     * @return PaginatedResponse instance
     */
    public static <T> PaginatedResponse<T> from(Page<T> page) {
        return PaginatedResponse.<T>builder()
                .items(page.getContent())
                .currentPage(page.getNumber() + 1)
                .totalPages(page.getTotalPages())
                .pageSize(page.getSize())
                .totalItems(page.getTotalElements())
                .build();
    }

    /**
     * Tạo PaginatedResponse từ Spring Page với entity → DTO mapping.
     *
     * @param page   Spring Page chứa entities
     * @param mapper Function để convert entity sang DTO
     * @param <E>    Kiểu entity
     * @param <D>    Kiểu DTO
     * @return PaginatedResponse chứa DTOs
     */
    public static <E, D> PaginatedResponse<D> from(Page<E> page, Function<E, D> mapper) {
        List<D> items = page.getContent().stream()
                .map(mapper)
                .toList();

        return PaginatedResponse.<D>builder()
                .items(items)
                .currentPage(page.getNumber() + 1)
                .totalPages(page.getTotalPages())
                .pageSize(page.getSize())
                .totalItems(page.getTotalElements())
                .build();
    }
}
