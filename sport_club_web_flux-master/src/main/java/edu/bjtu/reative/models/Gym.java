package edu.bjtu.reative.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
@Document
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Gym {
    private String id;
    private String name;
    private String address;
}
