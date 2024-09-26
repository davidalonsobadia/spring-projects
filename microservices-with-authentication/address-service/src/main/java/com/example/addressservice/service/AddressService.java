package com.example.addressservice.service;

import com.example.addressservice.model.Address;
import com.example.addressservice.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService {

    @Autowired
    private AddressRepository addressRepository;

    public Address addAddress(Address address, String username) {
        address.setUsername(username);
        return addressRepository.save(address);
    }

    public List<Address> getAddressesByUsername(String username) {
        return addressRepository.findByUsername(username);
    }

    public Address updateAddress(Long id, Address updatedAddress, String username) {
        Address address = addressRepository.findByIdAndUsername(id, username).orElseThrow();
        address.setStreet(updatedAddress.getStreet());
        address.setCity(updatedAddress.getCity());
        address.setState(updatedAddress.getState());
        address.setZipCode(updatedAddress.getZipCode());
        return addressRepository.save(address);
    }

    public void deleteAddress(Long id, String username) {
        Address existingAddress = addressRepository.findByIdAndUsername(id, username)
                .orElseThrow(() -> new RuntimeException("Address not found"));
        addressRepository.delete(existingAddress);
    }
}

