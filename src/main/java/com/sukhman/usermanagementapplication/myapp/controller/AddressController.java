package com.sukhman.usermanagementapplication.myapp.controller;

import com.sukhman.usermanagementapplication.myapp.domain.Address;
import com.sukhman.usermanagementapplication.myapp.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping("/address")
public class AddressController {

    @Autowired
    private AddressService addressService;

    @PostMapping("/create")
    public ResponseEntity<Objects> createAddress(@RequestBody Address address) {
        boolean status = addressService.createAddress(address);
        if (status) {
            return new ResponseEntity("Created Successfully", HttpStatus.CREATED);
        } else {
            return new ResponseEntity("Error Occurred While Creating ", HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/get")
    public ResponseEntity<List<Address>> getAddresses() {
        List<Address> addresses = addressService.getAllAddresses();
        if (!addresses.isEmpty()) {
            return new ResponseEntity(addresses, HttpStatus.OK);
        } else {
            return new ResponseEntity("Error Occurred While Returning List", HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{id}")
    Optional<Address> getAddressById(@PathVariable int id) {
        return addressService.getAddressById(id);
    }

    @PutMapping("/update")
    public ResponseEntity<Objects> updateAddress(@RequestBody Address address) {
        boolean status = addressService.updateAddress(address);
        if (status) {
            return new ResponseEntity("Updated Successfully", HttpStatus.ACCEPTED);
        } else {
            return new ResponseEntity("Error Occurred While Updating ", HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Objects> deleteAddress(@PathVariable int id) {
        boolean status = addressService.deleteAddress(id);
        if (status) {
            return new ResponseEntity("Deleted Successfully", HttpStatus.ACCEPTED);
        } else {
            return new ResponseEntity("Error Occurred While Deleting ", HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/deleteAll")
    public ResponseEntity<Objects> deleteAllAddresses() {
        boolean status = addressService.deleteAllAddresses();
        if (status) {
            return new ResponseEntity("Deleted Successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity("Error Occurred While Deleting ", HttpStatus.BAD_REQUEST);
        }
    }
}
