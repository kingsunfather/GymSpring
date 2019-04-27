package com.springboot.jpa_demo.datasource1.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@Entity
@Table(name = "trainer")
public class Trainer implements Serializable {
    @Id
    private String id;
    private String name;
    private String age;
    private String headpic;
    private String introduce;
    private String phone;
}
