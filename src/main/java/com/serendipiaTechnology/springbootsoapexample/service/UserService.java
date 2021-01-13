package com.serendipiaTechnology.springbootsoapexample.service;

import com.serendipiatechnology.spring_boot_soap_example.User;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Service
public class UserService {

    private static final Map<String, User> users = new HashMap<>();

    @PostConstruct
    public void initialize() {

        User renny = new User();
        renny.setName("Renny Donny");
        renny.setEmpId(111);
        renny.setSalary(999999);

        users.put(renny.getName(),renny);
    }

    public User getUsers(String name) {
        return users.get(name);
    }
}
