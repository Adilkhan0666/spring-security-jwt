package com.springsecurity.springbootsecurity.service;

import com.springsecurity.springbootsecurity.entity.UserRegistrationEntity;
import com.springsecurity.springbootsecurity.repository.UserRegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CustomUserDetailsService implements UserDetailsService{

    @Autowired
    private UserRegistrationRepository userRegistrationRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UserRegistrationEntity userRegistrationEntity = userRegistrationRepository.findByUserName(username);
        if (null == userRegistrationEntity){
            throw new UsernameNotFoundException("User Not found ");
        }
        //use db for auth.
        if (username.equals(userRegistrationEntity.getUserName())){
            return new User(username,userRegistrationEntity.getPassword(),new ArrayList<>());
        }else {
            throw new UsernameNotFoundException("User not found !!");
        }

    }
}
