package com.ibm.business.db.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.ibm.business.db.entity.AccessToken;

@EnableJpaRepositories
public interface AccessTokenRepository extends JpaRepository<AccessToken, String> {

    Optional<AccessToken> findByDeviceId(String deviceId);

    Optional<AccessToken> findByAccessToken(String accessToken);
    
    Optional<AccessToken> findByOauthAccessToken(String oauthAccessToken);
}
