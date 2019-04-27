package com.springboot.gym_spring.datasource1.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Data
@Table(name = "gym_trainer")
public class GymTrainer implements Serializable {

    @Id
    private String gym_id;
    @Id
    private String trainer_id;
}
