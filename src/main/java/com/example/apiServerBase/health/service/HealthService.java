package com.example.apiServerBase.health.service;

import com.example.apiServerBase.base.dto.request.PaginatedRequest;
import com.example.apiServerBase.base.dto.response.PaginatedResponse;
import com.example.apiServerBase.health.dto.HealthRequest;
import com.example.apiServerBase.health.dto.HealthResponse;
import com.example.apiServerBase.health.entity.Health;
import com.example.apiServerBase.health.repo.HealthRepo;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class HealthService {

    private final HealthRepo healthRepository;

    @Transactional(readOnly = true)
    public PaginatedResponse<HealthResponse> findAll(PaginatedRequest request) {
        Page<Health> page = healthRepository.findAll(request.toPageable());
        return PaginatedResponse.from(page, HealthResponse::from);
    }

    @Transactional(readOnly = true)
    public HealthResponse findById(Long id) {
        Health entity = healthRepository.findById(id)
                .orElseThrow();
        return HealthResponse.from(entity);
    }

    @Transactional
    public HealthResponse create(HealthRequest request) {
        Health entity = Health.builder().build();
        Health saved = healthRepository.save(entity);
        return HealthResponse.from(saved);
    }

    @Transactional
    public HealthResponse update(Long id, HealthRequest request) {
        Health entity = healthRepository.findById(id)
                .orElseThrow();
        Health saved = healthRepository.save(entity);
        return HealthResponse.from(saved);
    }

    @Transactional
    public void delete(Long id) {
        healthRepository.deleteById(id);
    }
}
