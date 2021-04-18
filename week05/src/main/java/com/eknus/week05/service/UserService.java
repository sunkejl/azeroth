package com.eknus.week05.service;

import com.eknus.week05.entity.Student;
import com.eknus.week05.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserService {
    @Autowired
    User user;

    @Autowired
    Student student;

    public void showUser() {
        user.setName("user01");
        user.setAge(12);
        System.out.println(user);
    }

    public void showStudent(){
        student.setName("student01");
        student.setAge(21);
        System.out.println(student);
    }
}
