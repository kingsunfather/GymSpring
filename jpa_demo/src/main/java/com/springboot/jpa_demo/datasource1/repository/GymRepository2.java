package com.springboot.jpa_demo.datasource1.repository;

import com.springboot.jpa_demo.datasource1.domain.Gym;
import org.springframework.data.repository.CrudRepository;

public interface GymRepository2 extends CrudRepository<Gym, Integer> {
   //有count方法,exist方法
}
