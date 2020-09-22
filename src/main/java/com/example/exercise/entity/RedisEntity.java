package com.example.exercise.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@ToString
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RedisEntity implements Serializable {
    private int _id;
    private String name;
    private int age;
    private int money;
}
