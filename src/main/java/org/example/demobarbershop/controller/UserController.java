package org.example.demobarbershop.controller;

import org.example.demobarbershop.dto.UserDto;
import org.example.demobarbershop.model.Result;
import org.example.demobarbershop.model.User;
import org.example.demobarbershop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> getAll() {
        return userService.getAll();
    }

    @GetMapping("/{id}")
    public User getById(@PathVariable Integer id) {
        return userService.getById(id);
    }

    @PostMapping
//    public User create(@RequestBody UserDto userDto) {
//        return userService.create(userDto);
//    }

    @PutMapping("/{id}")
    public Result update(@PathVariable Integer id, @RequestBody UserDto userDto) {
        return userService.update(id, userDto);
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        return userService.delete(id);
    }
}
