package com.springboot.jpa_demo.datasource1.repository;

import com.springboot.jpa_demo.datasource1.domain.Gym;
import io.swagger.models.auth.In;
import org.springframework.data.repository.Repository;

public interface GymRepository3 extends Repository<Gym, Integer> {

    /**
     * steos
     *
     * 1.Defining Repository Interfaces
     *
     * 2.Defining Query Methods
     *
     * 3.Creating Repository Instances
     *
     * 4.Custom Implementations for Spring Data Repositories
     */
}
