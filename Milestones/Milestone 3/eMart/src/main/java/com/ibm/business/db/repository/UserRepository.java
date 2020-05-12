package com.ibm.business.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.ibm.business.db.entity.User;

@EnableJpaRepositories
public interface UserRepository extends JpaRepository<User, Long> {

}
