package com.jwt.jwtauthenticationexample.jwtauthexample.services;

import com.jwt.jwtauthenticationexample.jwtauthexample.model.CustomUserDetails;
import com.jwt.jwtauthenticationexample.jwtauthexample.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
//        final User user=this.userRepository.findByUsername(userName);
//        if(user==null){
//            throw new UsernameNotFoundException("User Not found");
//        }else{
//            return new CustomUserDetails(user);
//        }
        if(userName.equals("shafaat")){
            return new User("shafaat","shafaat",new ArrayList<>());
        }else{
            throw new UsernameNotFoundException("User Not found");
        }
    }
}
