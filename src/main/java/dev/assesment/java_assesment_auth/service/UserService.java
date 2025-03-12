package dev.assesment.java_assesment_auth.service;

import dev.assesment.java_assesment_auth.entity.Users;
import dev.assesment.java_assesment_auth.repository.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


@Service
public class UserService {

    private final UserRepository userRepository;


    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    //GET ALL USERS
    public List<Users> allUsers(){
        return userRepository.findAll();
    }


    //VERIFIED USER
    @Transactional()
    public ResponseEntity<Void> verifiedUser(String id, Boolean verify){
        return userRepository.verifiedAccount(id, verify);
    }




}
