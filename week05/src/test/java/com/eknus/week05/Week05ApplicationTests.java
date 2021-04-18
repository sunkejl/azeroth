package com.eknus.week05;

import com.eknus.week05.entity.Student;
import com.eknus.week05.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Week05ApplicationTests {
    @Autowired
    UserService userService;
    @Autowired
    Student student;

    @Test
    void contextLoads() {
    }

    @Test
    void test1() {
        userService.showUser();
    }

    @Test
    void test2(){
        userService.showStudent();
    }

}
