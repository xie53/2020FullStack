package com.ibm.business.db.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.ibm.business.db.entity.PbkApplicationConfiguration;

@EnableJpaRepositories
public interface PbkApplicationConfigurationRepository extends JpaRepository<PbkApplicationConfiguration, Long> {
    
    Optional<PbkApplicationConfiguration> findByAppSecret(String appSecret);
}
