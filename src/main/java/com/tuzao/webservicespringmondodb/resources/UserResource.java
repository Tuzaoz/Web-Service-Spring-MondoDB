package com.tuzao.webservicespringmondodb.resources;

import com.tuzao.webservicespringmondodb.domain.entities.User;
import com.tuzao.webservicespringmondodb.dto.UserDTO;
import com.tuzao.webservicespringmondodb.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
    @Autowired
    private UserService userService;
    @GetMapping
    public ResponseEntity<List<UserDTO>> finAll(){
        List<User> users = userService.findAll();
        List<UserDTO> userDTOS = users.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());
        return ResponseEntity.ok().body(userDTOS);
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<UserDTO> findById(@PathVariable String id){
        User user = userService.findById(id);
        return ResponseEntity.ok().body(new UserDTO(user));
    }
    @PostMapping
    public ResponseEntity<Void> insert(@RequestBody UserDTO userDTO ){
        User user = userService.fromDTO(userDTO);
        user = userService.insert(user);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }
    @DeleteMapping (value = "/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable String id){
        userService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
    @PutMapping(value = "/{id}")
    public ResponseEntity<Void> update(@RequestBody UserDTO userDTO, @PathVariable String id ){
        User user = userService.fromDTO(userDTO);
        user.setId(id);
        user = userService.update(user);
        return ResponseEntity.noContent().build();
    }

}
