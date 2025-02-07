package io.manojlearns.securingwebwithmysql.services;


import io.manojlearns.securingwebwithmysql.models.User;

import io.manojlearns.securingwebwithmysql.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import lombok.*;


@Service
public class UserService implements UserDetailsService {

    @Autowired
    public UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{

        return userRepo.findByUsername(username);
    }

    public String create(String username, String password){
        User user = User.builder()
                .username(username)
                .password(new BCryptPasswordEncoder().encode(password))
                .authorities("student")
                .build();

            userRepo.save(user);
            return "Created Successfully !";
    }

}
