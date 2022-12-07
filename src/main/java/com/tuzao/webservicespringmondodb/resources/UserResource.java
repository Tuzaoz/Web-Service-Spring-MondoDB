package com.tuzao.webservicespringmondodb.resources;

import com.tuzao.webservicespringmondodb.domain.entities.User;
import com.tuzao.webservicespringmondodb.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
    @Autowired
    private UserService userService;
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<User>> finAll(){
        List<User> users = userService.findAll();
        return ResponseEntity.ok().body(users);
    }
}
