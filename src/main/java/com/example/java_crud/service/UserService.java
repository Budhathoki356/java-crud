package com.example.java_crud.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.java_crud.repository.UserRepository;
import com.example.java_crud.entity.User;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public User findById(int id) {
        Optional<User> user = userRepository.findById(id);

        if(user.isEmpty()) {
            throw new RuntimeException("User not found");
        }
         return user.get();
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User updateUser(User user) {

        Optional<User> userOptional = userRepository.findById(user.getId());

        if(userOptional.isEmpty()) {
            throw new RuntimeException("User not found");
        }

        User updatedUser = userOptional.get();
        updatedUser.setUsername(user.getUsername());

        return userRepository.save(updatedUser);
    }

    public String deleteUser(int id) {
        Optional<User> user = userRepository.findById(id);

        if(user.isEmpty()) {
            throw new RuntimeException("User not found");
        }

        userRepository.delete(user.get());

        return "User deleted";
    }
}
