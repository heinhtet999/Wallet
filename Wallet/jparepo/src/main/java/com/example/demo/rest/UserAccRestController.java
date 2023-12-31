package com.example.demo.rest;


import com.example.demo.entity.Users;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserAccRestController {
    private UserService userService;


    @Autowired
    public UserAccRestController(UserService theuserService) {
        userService = theuserService;
    }

    @GetMapping("/users")
    public List<Users> findAll(){
        return userService.findAll();
    }

    @GetMapping("/users/{userId}")
    public Users getUsers(@PathVariable int userId){
        Users thUsers = userService.fibdById(userId);
        if(thUsers == null){
            throw new RuntimeException("Employee ID not found "+userId);
        }
        return thUsers;
    }

    @PostMapping("/users")
    public Users addUsers(@RequestBody Users theUsers){
        theUsers.setUserId(0L);
        Users dbUsers = userService.save(theUsers);
        return dbUsers;
    }

    @PutMapping("/users")
    public Users updateUsers(@RequestBody Users theUsers){
        Users dbUsers=userService.save(theUsers);
        return dbUsers;
    }

    @DeleteMapping("/users/{userId}")
    public String deleteUsers(@PathVariable int userId){

        Users tempUsers=userService.fibdById(userId);
        if(tempUsers == null){
            throw new RuntimeException("User not found"+userId);
        }
        userService.deleteById(userId);
        return "Delete user "+userId;
    }
}
