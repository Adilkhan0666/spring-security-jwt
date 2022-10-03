package com.springsecurity.springbootsecurity.service;

import com.springsecurity.springbootsecurity.model.User;
import lombok.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {


    public List<User> getUser() {
        ArrayList<User> list = new ArrayList<>();

        User user1 = new User("Adil", "adil");
        User user2 = new User("Abid", "abid");
        User user3 = new User("Muzi", "muzi");

        list.add(user1);
        list.add(user2);
        list.add(user3);

        return list;
    }


}
