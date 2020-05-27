package com.ibm.business.buyer.db.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.ibm.business.buyer.db.entity.AccessToken;

@EnableJpaRepositories
public interface AccessTokenRepository extends JpaRepository<AccessToken, String> {

    Optional<AccessToken> findByAccessToken(String accessToken);
}
