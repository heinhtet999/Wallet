package com.example.demo.service;

import com.example.demo.dao.UserRepository;
import com.example.demo.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImp implements UserService{

    private UserRepository userRepository;

    @Autowired
    public UserServiceImp(UserRepository theuserRepository) {
        userRepository = theuserRepository;
    }

    @Override
    public List<Users> findAll() {
        return userRepository.findAll();
    }

    @Override
    public Users fibdById(int theId) {
        Optional<Users> result = userRepository.findById(theId);
        Users theUsers=null;
        if(result.isPresent()){
            theUsers = result.get();
        }else {
            throw new RuntimeException("Did not find the Id"+theId);
        }
        return theUsers;
    }


    @Override
    public Users save(Users theUsers) {
        return userRepository.save(theUsers);
    }

   
    @Override
    public void deleteById(int theId) {
        userRepository.deleteById(theId);

    }
}
