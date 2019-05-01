package com.springboot.jpa_demo.datasource2.domain;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Getter
@Setter
@ToString
@EntityListeners(AuditingEntityListener.class)
public class Trainer implements Serializable {
    @Id
    private String id;
    private String name;
    private String age;
    private String headpic;
    private String introduce;
    private String phone;

    @ManyToOne(cascade={CascadeType.MERGE,CascadeType.REFRESH},optional=false)
    @JoinColumn(name="gym_id")
    private Gym gym;

    @CreatedDate
    private Date createAt;

    @LastModifiedDate
    private Date updateAt;

}
