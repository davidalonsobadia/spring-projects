package com.example.addressservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.addressservice.model.Address;

import java.util.List;
import java.util.Optional;

public interface AddressRepository extends JpaRepository<Address, Long> {

    List<Address> findByUsername(String username);

    Optional<Address> findByIdAndUsername(Long id, String username);

}
