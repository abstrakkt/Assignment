package com.addressbook.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.addressbook.persistence.entity.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> {

}
