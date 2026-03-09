package com.example.apiServerBase.base.database;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;

/**
 * Base repository interface cho tất cả domain repositories.
 *
 * <p>Cung cấp các CRUD operations cơ bản thông qua JpaRepository:
 * <ul>
 *   <li>findAll() - Lấy tất cả entities</li>
 *   <li>findById(id) - Lấy entity theo id</li>
 *   <li>findAll(Pageable) - Lấy entities với pagination</li>
 *   <li>save(entity) - Tạo hoặc cập nhật entity</li>
 *   <li>deleteById(id) - Xóa entity theo id</li>
 *   <li>count() - Đếm số entities</li>
 * </ul>
 *
 * <p>JpaSpecificationExecutor cho phép dynamic queries với Specification pattern.
 *
 * @param <T> Entity type (extends BaseEntity)
 */
@NoRepositoryBean
public interface IBaseRepository<T extends BaseEntity>
        extends JpaRepository<T, Long>, JpaSpecificationExecutor<T> {

    // JpaRepository đã cung cấp sẵn các CRUD operations:
    //
    // CREATE:
    //   - save(S entity) -> S
    //   - saveAll(Iterable<S> entities) -> List<S>
    //
    // READ:
    //   - findById(Long id) -> Optional<T>
    //   - findAll() -> List<T>
    //   - findAll(Pageable pageable) -> Page<T>
    //   - findAll(Sort sort) -> List<T>
    //   - findAllById(Iterable<Long> ids) -> List<T>
    //   - existsById(Long id) -> boolean
    //   - count() -> long
    //
    // UPDATE:
    //   - save(S entity) -> S (cũng dùng cho update)
    //
    // DELETE:
    //   - deleteById(Long id) -> void
    //   - delete(T entity) -> void
    //   - deleteAll() -> void
    //   - deleteAllById(Iterable<Long> ids) -> void
    //
    // JpaSpecificationExecutor cung cấp:
    //   - findOne(Specification<T>) -> Optional<T>
    //   - findAll(Specification<T>) -> List<T>
    //   - findAll(Specification<T>, Pageable) -> Page<T>
    //   - count(Specification<T>) -> long
}
