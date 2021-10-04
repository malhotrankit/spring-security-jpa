package com.ankit.springsecurity.springsecurityjpa.repository;

import com.ankit.springsecurity.springsecurityjpa.security.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer>
{
    Optional<User> findByUserName(String userName);
}
