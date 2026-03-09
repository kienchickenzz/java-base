package com.example.apiServerBase.base.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

/**
 * JPA configuration class.
 *
 * <p>Enable JPA Auditing để @CreatedDate và @LastModifiedDate
 * trong BaseEntity tự động được populate.
 */
@Configuration
@EnableJpaAuditing
public class JpaConfig {
}
