package com.springboot.jpa_demo.datasource1.domain;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
@Data
@EntityListeners(AuditingEntityListener.class)
public class Gym implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private String id;
    private String name;
    private String location;
    private String phone;

    @ManyToMany(mappedBy = "GymList")
    private List<User> userList;

    @OneToMany(mappedBy = "gym",cascade= CascadeType.ALL,fetch= FetchType.LAZY)
    private List<Trainer> trainerList;

    @CreatedDate
    private Date createAt;

    @LastModifiedDate
    private Date updateAt;
}
