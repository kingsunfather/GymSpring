package edu.bjtu.reative.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
@Document
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private String id;
    private String username;
    private String password;
    private String name;
    private String mail;
    private String phoneNumber;
    private Integer age;
    //0为普通用户 1为会员
    private Integer role;
    //1为男 0为女
    private Integer sex;
}
