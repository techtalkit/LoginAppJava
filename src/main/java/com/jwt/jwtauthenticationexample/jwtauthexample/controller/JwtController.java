package com.jwt.jwtauthenticationexample.jwtauthexample.controller;

import com.jwt.jwtauthenticationexample.jwtauthexample.helper.JwtUtil;
import com.jwt.jwtauthenticationexample.jwtauthexample.model.JwtRequest;
import com.jwt.jwtauthenticationexample.jwtauthexample.model.JwtResponse;
import com.jwt.jwtauthenticationexample.jwtauthexample.services.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
public class JwtController {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private CustomUserDetailsService customUserDetailsService;
    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/token")
    public ResponseEntity<?> generateToken(@RequestBody JwtRequest jwtRequest) throws Exception {
        System.out.println(jwtRequest);
        try{
           this.authenticationManager.authenticate(new
                   UsernamePasswordAuthenticationToken(jwtRequest.getUsername(),jwtRequest.getPassword()));
        }catch(UsernameNotFoundException e){
         e.printStackTrace();
         throw new Exception("Bad Credentials");
        }
        catch(BadCredentialsException e){
            e.printStackTrace();
            throw new Exception("Bad Credentials");
        }
        UserDetails userDetails=this.customUserDetailsService.loadUserByUsername(jwtRequest.getUsername());
        String token=this.jwtUtil.generateToken(userDetails);
        System.out.println("JWT "+token);
        //Return token {'token':'value'}
        return  ResponseEntity.ok(new JwtResponse(token));
    }
}
