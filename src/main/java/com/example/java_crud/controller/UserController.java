package com.example.java_crud.controller;

import com.example.java_crud.entity.User;
import com.example.java_crud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/save")
    public User save(@RequestBody User user) {
        return userService.saveUser(user);
    }

    @GetMapping("/findAll")
    public List<User> findAll() {
        return userService.findAll();
    }

    @GetMapping("/findById")
    public User findById(@RequestParam("id") int id) {
        return userService.findById(id);
    }

    @PutMapping("/update")
    public User update(@RequestBody User user) {
        return userService.updateUser(user);
    }

    @DeleteMapping("/delete")
    public String deleteById(@RequestParam("id") int id) {
        return userService.deleteUser(id);
    }
}
