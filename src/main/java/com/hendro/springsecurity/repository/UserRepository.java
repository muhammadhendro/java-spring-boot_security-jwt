package com.hendro.springsecurity.repository;

import com.hendro.springsecurity.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User getDistinctTopByUsername(String username);
    User getDistinctTopByPhone(String phone);
}
