package com.springboot.jpa_demo.datasource2.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "gym2")
public class Gym2 {
    @Id
    private String id;
    private String name;
    private String location;
    private String phone;
}
