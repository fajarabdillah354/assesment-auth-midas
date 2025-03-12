package dev.assesment.java_assesment_auth.service;

import dev.assesment.java_assesment_auth.entity.Users;
import dev.assesment.java_assesment_auth.payload.request.LoginRequest;
import dev.assesment.java_assesment_auth.payload.request.RegisterRequest;
import dev.assesment.java_assesment_auth.repository.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AuthenticationService {


    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    private final AuthenticationManager authenticationManager;


    public AuthenticationService(UserRepository userRepository, PasswordEncoder passwordEncoder, AuthenticationManager authenticationManager) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
    }

    public Users signup(RegisterRequest input){

        Users users = new Users();
        users.setFullname(input.getFullname());
        users.setEmail(input.getEmail());
        users.setPassword(passwordEncoder.encode(input.getPassword()));

        return userRepository.save(users);
    }

    public Users authenticate(LoginRequest loginRequest){
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getEmail(),
                        loginRequest.getPassword()
                )
        );

        return userRepository.findByEmail(loginRequest.getEmail()).orElseThrow();
    }




}
