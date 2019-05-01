package com.springboot.jpa_demo.datasource2.repository;


import com.springboot.jpa_demo.datasource2.domain.Gym;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Gym2Repository extends JpaRepository<Gym,Integer> {

}
