package com.springboot.gym_spring.datasource1.domain;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@Table(name = "user")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String sex;
    private String mobile;
    private int age;
    private String password;

    public String getPassword(){
        return password;
    }
}
