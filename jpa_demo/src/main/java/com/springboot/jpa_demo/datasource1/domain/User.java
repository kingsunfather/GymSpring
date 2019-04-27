package com.springboot.jpa_demo.datasource1.domain;

import lombok.Data;
import lombok.NonNull;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@Table(name = "user")
public class User implements Serializable {

    @Id
    private Long id;
    private String name;
    private String sex;
    private String mobile;
    private int age;
    private String password;

}
