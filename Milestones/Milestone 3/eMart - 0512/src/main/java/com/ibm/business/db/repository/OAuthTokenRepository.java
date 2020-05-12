package com.ibm.business.db.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.ibm.business.db.entity.OAuthToken;

@EnableJpaRepositories
public interface OAuthTokenRepository extends JpaRepository<OAuthToken, Long> {

    Optional<OAuthToken> findByDeviceId(String deviceId);

}
