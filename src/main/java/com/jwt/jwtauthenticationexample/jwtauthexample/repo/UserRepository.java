package com.jwt.jwtauthenticationexample.jwtauthexample.repo;

import com.jwt.jwtauthenticationexample.jwtauthexample.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
    //username, it will return the user of the given username
    public User findByUsername(String username);
}
