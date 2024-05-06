package com.sukhman.usermanagementapplication.myapp.service;

import com.sukhman.usermanagementapplication.myapp.domain.Address;

import java.util.List;
import java.util.Optional;

public interface AddressService {
    boolean createAddress(Address address);

    List<Address> getAllAddresses();

    Optional<Address> getAddressById(int id);

    boolean updateAddress(Address address);

    boolean deleteAddress(int id);

    boolean deleteAllAddresses();
}
