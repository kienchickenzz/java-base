package com.example.apiServerBase.health.entity;

import com.example.apiServerBase.base.database.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "health")
@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
public class Health extends BaseEntity {
    // Kế thừa tất cả fields từ BaseEntity: id, createdAt, updatedAt
}
