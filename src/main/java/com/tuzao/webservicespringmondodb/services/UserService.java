package com.tuzao.webservicespringmondodb.services;

import com.tuzao.webservicespringmondodb.domain.entities.User;
import com.tuzao.webservicespringmondodb.dto.UserDTO;
import com.tuzao.webservicespringmondodb.excpetions.ObjectNotFoundException;
import com.tuzao.webservicespringmondodb.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    public List<User> findAll(){
        return userRepository.findAll();

    }
    public User findById(String id) {
        Optional<User> obj = userRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }
    public User insert(User user){
        return userRepository.insert(user);
    }
    public User fromDTO(UserDTO userDTO){
        return new User(userDTO.getId(),userDTO.getName(), userDTO.getEmail());
    }
}
