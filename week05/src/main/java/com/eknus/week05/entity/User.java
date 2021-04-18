package com.eknus.week05.entity;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class User {
    private int age;
    private String name;
}
