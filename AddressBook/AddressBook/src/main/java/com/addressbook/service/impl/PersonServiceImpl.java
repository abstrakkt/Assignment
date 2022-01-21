package com.addressbook.service.impl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.addressbook.exception.ResourceNotFoundException;
import com.addressbook.persistence.entity.Person;
import com.addressbook.persistence.repository.PersonRepository;
import com.addressbook.service.PersonService;

@Service
@Transactional
public class PersonServiceImpl implements PersonService {

	@Autowired
	private PersonRepository personRepository;

	@Override
	public Person createPerson(Person person) {
		return personRepository.save(person);
	}

	@Override
	public Person updatePerson(String username, Person person) {
		Optional<Person> personOpt = personRepository.findByUsername(username);

		if (personOpt.isPresent()) {
			Person resObj = personOpt.get();
			resObj.setId(person.getId());
			resObj.setFirstName(person.getFirstName());
			resObj.setLastName(person.getLastName());
			resObj.setContactNo(person.getContactNo());
			resObj.setUsername(person.getUsername());
			resObj.setAddress(person.getAddress());
			return resObj;
		} else {
			throw new ResourceNotFoundException("Record not found with id : " + person.getId());
		}
	}

	@Override
	public List<Person> getAllPerson() {
		return personRepository.findAll();
	}

	@Override
	public Person getPersonByUsername(String username) {
		Optional<Person> personOpt = personRepository.findByUsername(username);
		if (personOpt.isPresent()) {
			return personOpt.get();
		} else {
			throw new ResourceNotFoundException("Record not found with username : " + username);
		}
	}

	@Override
	public void deletePerson(String username) {
		Optional<Person> personOpt = this.personRepository.findByUsername(username);
		if (personOpt.isPresent()) {
			this.personRepository.delete(personOpt.get());
		} else {
			throw new ResourceNotFoundException("Record not found with username : " + username);
		}
	}

}
