package com.sukhman.usermanagementapplication.myapp.service;

import com.sukhman.usermanagementapplication.myapp.domain.Address;
import com.sukhman.usermanagementapplication.myapp.repository.AddressRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressRepo addressRepo;

    @Override
    public boolean createAddress(Address address) {
        try {
            addressRepo.save(address);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public List<Address> getAllAddresses() {
        return addressRepo.findAll();
    }

    @Override
    public Optional<Address> getAddressById(int id) {
        return addressRepo.findById(String.valueOf(id));
    }

    @Override
    public boolean updateAddress(Address address) {
        try {
            addressRepo.save(address);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean deleteAddress(int id) {
        try {
            addressRepo.deleteById(String.valueOf(id));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean deleteAllAddresses() {
        try {
            addressRepo.deleteAll();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
