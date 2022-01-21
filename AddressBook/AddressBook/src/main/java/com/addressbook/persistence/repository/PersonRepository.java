package com.addressbook.persistence.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.addressbook.persistence.entity.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {

	@Query(value = "SELECT * FROM PERSON WHERE USERNAME = ?1", nativeQuery = true)
	public Optional<Person> findByUsername(String username);

}
