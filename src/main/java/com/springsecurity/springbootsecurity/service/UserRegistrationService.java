package com.springsecurity.springbootsecurity.service;

import com.springsecurity.springbootsecurity.entity.UserRegistrationEntity;
import com.springsecurity.springbootsecurity.model.User;
import com.springsecurity.springbootsecurity.repository.UserRegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserRegistrationService {

    @Autowired
    private UserRegistrationRepository userRegistrationRepository;

    public User registerUser(User user){
        UserRegistrationEntity userRegistrationEntity = new UserRegistrationEntity();
        userRegistrationEntity.setUserName(user.getUserName());
        userRegistrationEntity.setPassword(user.getPassword());
        userRegistrationRepository.save(userRegistrationEntity);
        return user;
    }


}
