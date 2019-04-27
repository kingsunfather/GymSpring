package com.springboot.gym_spring.datasource1.repository;

import com.springboot.gym_spring.datasource1.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepositpry extends JpaRepository<User,Integer> {
    public User findById(Long id);
}
