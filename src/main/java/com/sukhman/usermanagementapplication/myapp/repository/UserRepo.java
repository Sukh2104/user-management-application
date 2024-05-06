package com.sukhman.usermanagementapplication.myapp.repository;

import com.sukhman.usermanagementapplication.myapp.domain.UserData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<UserData, Integer> {
}
