package com.springboot.jpa_demo.datasource1.repository;

import com.alibaba.fastjson.JSONObject;
import com.springboot.jpa_demo.datasource1.domain.Gym;
import org.hibernate.mapping.Collection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.lang.Nullable;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.LockModeType;
import java.util.List;

public interface GymRepository extends JpaRepository<Gym,Integer> {
    @Lock(LockModeType.READ)
    Gym findById(int id);
    List<Gym> findByIdOrName(String id, String name);
    List<Gym> findByNameLike(@Nullable String name);
    List<Gym> findByNameContaining(String name);
    List<Gym> findByNameIn(Collection name);

    Page<Gym> findAll(Pageable pageable);
    Gym saveAndFlush(Gym gym);
    Gym getOne(Integer gymId);

//    @Transactional(timeout = 10)
    @Query(nativeQuery = true,value = "select gym.id as gymId ,gym.name as gymName, trainer.id as trainerId,trainer.name as trainerName " +
            "from gym " +
            "left join gym_trainer on gym_trainer.gym_id=gym.id " +
            "left join trainer on trainer.id=gym_trainer.trainer_id " +
            "where gym.id=?1")
    List<JSONObject> getGymTrainer(String id);
    List<Gym> findByNameContainingOrderById(String name);
    List<Gym> findFirst10ById(String id);


}
