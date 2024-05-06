package com.sukhman.usermanagementapplication.myapp.repository;

import com.sukhman.usermanagementapplication.myapp.domain.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepo extends JpaRepository<Address, String> {

}
