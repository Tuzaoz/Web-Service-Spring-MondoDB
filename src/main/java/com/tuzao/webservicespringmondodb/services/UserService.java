package com.tuzao.webservicespringmondodb.services;

import com.tuzao.webservicespringmondodb.domain.entities.User;
import com.tuzao.webservicespringmondodb.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    public List<User> findAll(){
        return userRepository.findAll();

    }
}
