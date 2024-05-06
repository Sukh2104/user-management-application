package com.sukhman.usermanagementapplication.myapp.service;

import com.sukhman.usermanagementapplication.myapp.domain.UserData;
import com.sukhman.usermanagementapplication.myapp.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;

    @Override
    public boolean insertUser(UserData userData) {
        try {
            userRepo.save(userData);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public List<UserData> getAllUsers() {
        try {
            return userRepo.findAll();
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public Optional<UserData> getUsersById(int id) {
        try {
            return userRepo.findById(id);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public boolean updateUser(UserData userData) {
        try {
            userRepo.save(userData);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean deleteUser(int id) {
        try {
            userRepo.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean deleteAllUsers() {
        try {
            userRepo.deleteAll();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
