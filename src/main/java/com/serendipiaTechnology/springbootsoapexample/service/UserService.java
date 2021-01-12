package com.serendipiaTechnology.springbootsoapexample.service;

import com.serendipiaTechnology.spring_boot_soap_example.User;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Service
public class UserService {

    private static final Map<String, User> users = new HashMap<>();

    @PostConstruct
    public void initialize() {

        User peter = new User();
        peter.setName("Peter");
        peter.setEmpId(1111);
        peter.setSalary(12000);

        User sam = new User();
        sam.setName("Sam");
        sam.setEmpId(1112);
        sam.setSalary(32000);
        User ryan = new User();
        ryan.setName("Ryan");
        ryan.setEmpId(1113);
        ryan.setSalary(16000);
        User renny = new User();
        ryan.setName("Renny Donny");
        ryan.setEmpId(2021);
        ryan.setSalary(99999);

        users.put(peter.getName(), peter);
        users.put(sam.getName(), sam);
        users.put(ryan.getName(), ryan);
        users.put(renny.getName(),renny);
    }


    public User getUsers(String name) {
        return users.get(name);
    }
}
