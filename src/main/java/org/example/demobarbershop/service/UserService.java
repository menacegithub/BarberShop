package org.example.demobarbershop.service;

import org.example.demobarbershop.dto.UserDto;
import org.example.demobarbershop.model.Result;
import org.example.demobarbershop.model.User;
import org.example.demobarbershop.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // Get all users
    public List<User> getAll() {
        return userRepository.findAll();
    }

    // Get user by ID
    public User getById(Integer id) {
        return userRepository.findById(id).orElse(null);
    }

    // Create new user
    public User create(UserDto userDto) {
        if (userDto == null || userDto.getUsername() == null || userDto.getPhoneNumber() == null) {
            throw new IllegalArgumentException("User data is incomplete");
        }
        User user = new User();
        user.setUsername(userDto.getUsername());
        user.setPassword(userDto.getPassword());
        user.setPhoneNumber(userDto.getPhoneNumber());
        user.setEmail(userDto.getEmail());
        return userRepository.save(user);
    }


    // Update existing user
    public Result update(Integer id, UserDto updatedUser) {
        User existingUser = userRepository.findById(id).orElse(null);
        if (existingUser == null) {
            return new Result(false, "User not found");
        }
        existingUser.setUsername(updatedUser.getUsername());
        existingUser.setEmail(updatedUser.getEmail());
        existingUser.setPassword(updatedUser.getPassword());
        existingUser.setPhoneNumber(updatedUser.getPhoneNumber());
        userRepository.save(existingUser);
        return new Result(true, "User updated successfully");
    }

    // Delete user
    public Result delete(Integer id) {
        if (!userRepository.existsById(id)) {
            return new Result(false, "User not found");
        }
        userRepository.deleteById(id);
        return new Result(true, "User deleted successfully");
    }
}
