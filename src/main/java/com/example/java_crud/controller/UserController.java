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

    @PostMapping()
    public User save(@RequestBody User user) {
        return userService.saveUser(user);
    }

    @GetMapping()
    public List<User> findAll() {
        return userService.findAll();
    }

    @GetMapping("{id}")
    public User findById(@PathVariable("id") int id) {
        return userService.findById(id);
    }

    @PutMapping("{id}")
    public User update(@PathVariable("id") int id, @RequestBody User user) {
        return userService.updateUser(user, id);
    }

    @DeleteMapping("{id}")
    public String deleteById(@PathVariable("id") int id) {
        return userService.deleteUser(id);
    }
}
