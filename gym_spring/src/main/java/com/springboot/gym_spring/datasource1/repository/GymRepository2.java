package com.springboot.gym_spring.datasource1.repository;

import com.springboot.gym_spring.datasource1.domain.Gym;
import org.springframework.data.repository.CrudRepository;

public interface GymRepository2 extends CrudRepository<Gym,Long> {
   //有count方法,exist方法
}
