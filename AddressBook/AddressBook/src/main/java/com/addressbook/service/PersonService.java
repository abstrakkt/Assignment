package com.addressbook.service;

import java.util.List;

import com.addressbook.persistence.entity.Person;

public interface PersonService {

	public Person createPerson(Person person);

	public Person updatePerson(String username, Person person);

	public List<Person> getAllPerson();
	
	public Person getPersonByUsername(String username);
	
	public void deletePerson(String username);
}
