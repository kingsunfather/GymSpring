package com.springboot.jpa_demo.datasource1.domain;

import lombok.Data;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Table(name = "gym")
@EntityListeners(AuditingEntityListener.class)
public class Gym implements Serializable {
    @Id
    private String id;
    private String name;
    private String location;
    private String phone;

    @LastModifiedDate
    private Date modifyDate;
}
