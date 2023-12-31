package com.example.demo.service;

import com.example.demo.entity.Users;
import org.springframework.context.annotation.Bean;

import java.util.List;


public interface UserService {

    List<Users> findAll();

    Users fibdById(int theId);

    Users save (Users theUsers);

    void deleteById(int theId);
}

