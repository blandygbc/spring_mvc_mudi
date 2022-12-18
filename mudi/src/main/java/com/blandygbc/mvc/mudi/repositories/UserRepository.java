package com.blandygbc.mvc.mudi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blandygbc.mvc.mudi.model.User;

public interface UserRepository extends JpaRepository<User, String> {

    User findByUsername(String username);
}
