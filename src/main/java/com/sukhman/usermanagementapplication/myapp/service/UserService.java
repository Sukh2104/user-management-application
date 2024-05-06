package com.sukhman.usermanagementapplication.myapp.service;

import com.sukhman.usermanagementapplication.myapp.domain.UserData;

import java.util.List;
import java.util.Optional;

public interface UserService {
    boolean insertUser(UserData userData);

    List<UserData> getAllUsers();

    Optional<UserData> getUsersById(int id);

    boolean updateUser(UserData userData);

    boolean deleteUser(int id);
    boolean deleteAllUsers();
}