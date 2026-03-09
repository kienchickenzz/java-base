package com.example.apiServerBase.health.controller;

import com.example.apiServerBase.base.dto.request.PaginatedRequest;
import com.example.apiServerBase.base.dto.response.PaginatedResponse;
import com.example.apiServerBase.health.dto.HealthRequest;
import com.example.apiServerBase.health.dto.HealthResponse;
import com.example.apiServerBase.health.service.HealthService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/health")
@RequiredArgsConstructor
@Tag(name = "Health", description = "Health management APIs")
public class HealthController {

    private final HealthService healthService;

    @GetMapping
    @Operation(summary = "Get all health records", description = "Returns paginated list of health records")
    public PaginatedResponse<HealthResponse> findAll(@Valid PaginatedRequest request) {
        return healthService.findAll(request);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get health by ID", description = "Returns a single health record")
    public HealthResponse findById(
            @Parameter(description = "Health ID") @PathVariable Long id) {
        return healthService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Create health", description = "Creates a new health record")
    public HealthResponse create(@Valid @RequestBody HealthRequest request) {
        return healthService.create(request);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update health", description = "Updates an existing health record")
    public HealthResponse update(
            @Parameter(description = "Health ID") @PathVariable Long id,
            @Valid @RequestBody HealthRequest request) {
        return healthService.update(id, request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Delete health", description = "Deletes a health record")
    public void delete(@Parameter(description = "Health ID") @PathVariable Long id) {
        healthService.delete(id);
    }
}
