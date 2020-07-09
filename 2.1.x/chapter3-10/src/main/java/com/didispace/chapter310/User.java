package com.didispace.chapter310;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Max;

@Entity
@Data
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    @Max(50)
    private Integer age;

    public User(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

}