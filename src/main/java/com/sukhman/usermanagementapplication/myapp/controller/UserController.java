package com.sukhman.usermanagementapplication.myapp.controller;

import com.sukhman.usermanagementapplication.myapp.domain.UserData;
import com.sukhman.usermanagementapplication.myapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/userdata")

public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/create")
    public ResponseEntity<Object> insertUser(@RequestBody UserData userData) {
        boolean result = userService.insertUser(userData);
        if (result) {
            return new ResponseEntity<>("Created Successfully", HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>("Failed To Create", HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/get")
    public ResponseEntity<List<UserData>> getAllUsers() {
        List<UserData> status = userService.getAllUsers();
        if (!status.isEmpty()) {
            return new ResponseEntity<>(status, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<UserData>> getUserById(@PathVariable int id) {
        Optional<UserData> data = userService.getUsersById(id);
        if (data.isPresent()) {
            return new ResponseEntity<>(data, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @PutMapping("/update")
    public ResponseEntity<Object> updateUser(@RequestBody UserData userData) {
        boolean result = userService.updateUser(userData);
        if (result) {
            return new ResponseEntity("Updated Successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity("Failed To Update", HttpStatus.BAD_REQUEST);
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteUser(@PathVariable int id) {
        boolean result = userService.deleteUser(id);
        if (result) {
            return new ResponseEntity<>("Deleted Successfully", HttpStatus.OK);
        }else{
            return new ResponseEntity<>("Failed To Delete", HttpStatus.BAD_REQUEST);
        }
    }
    @DeleteMapping("/deleteAll")
    public ResponseEntity<Object> deleteAllUsers() {
        boolean result = userService.deleteAllUsers();
        if (result) {
            return new ResponseEntity<>("Deleted Successfully", HttpStatus.OK);
        }else{
            return new ResponseEntity<>("Failed To Delete", HttpStatus.BAD_REQUEST);
        }
    }
}

