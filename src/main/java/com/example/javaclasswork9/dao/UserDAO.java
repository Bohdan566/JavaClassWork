package com.example.javaclasswork9.dao;

import com.example.javaclasswork9.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Service;

@Service
@EnableJpaRepositories
public interface UserDAO extends JpaRepository<User, Integer> {
}
