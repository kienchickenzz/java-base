package com.example.apiServerBase.health.repo;

import com.example.apiServerBase.base.database.IBaseRepository;
import com.example.apiServerBase.health.entity.Health;
import org.springframework.stereotype.Repository;

@Repository
public interface HealthRepo extends IBaseRepository<Health> {
    // Kế thừa tất cả methods từ IBaseRepository
}
