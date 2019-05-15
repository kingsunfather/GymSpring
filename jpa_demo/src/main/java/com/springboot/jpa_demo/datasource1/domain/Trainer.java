package com.springboot.jpa_demo.datasource1.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.io.Serializable;
import java.util.Date;

@Entity
@Getter
@Setter
@ToString
@EntityListeners(AuditingEntityListener.class)
public class Trainer implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    private String name;
    private String age;
    private String headpic;
    private String introduce;
    private String phone;

    @JsonManagedReference
    @ManyToOne(cascade = { CascadeType.MERGE, CascadeType.REFRESH }, optional = false)
    @JoinColumn(name = "gym_id")
    private Gym gym;

    @CreatedDate
    private Date createAt;

    @LastModifiedDate
    private Date updateAt;

    public Trainer(String name, String age, String headpic, String introduce, String phone, Gym gym) {
        this.gym = gym;
        this.name = name;
        this.age = age;
        this.headpic = headpic;
        this.introduce = introduce;
        this.phone = phone;

    }

    public Trainer() {
    }
}
