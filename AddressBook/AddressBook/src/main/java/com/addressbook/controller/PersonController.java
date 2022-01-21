package com.addressbook.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.addressbook.persistence.entity.Person;
import com.addressbook.service.PersonService;

@RestController
@RequestMapping("/addressbook")
public class PersonController {

	@Autowired
	private PersonService personService;

	@PostMapping("/create")
	public ResponseEntity<Person> createPerson(@RequestBody Person requestObj) {
		return ResponseEntity.ok().body(personService.createPerson(requestObj));
	}

	@GetMapping("/person/{username}")
	public ResponseEntity<Person> getPersonByUsername(@PathVariable String username) {
		return ResponseEntity.ok().body(personService.getPersonByUsername(username));
	}

	@GetMapping("/person")
	public ResponseEntity<List<Person>> getAllPerson() {
		return ResponseEntity.ok().body(personService.getAllPerson());
	}

	@PutMapping("/person/{username}")
	public ResponseEntity<Person> updatePerson(@PathVariable String username, @RequestBody Person person) {
		return ResponseEntity.ok().body(this.personService.updatePerson(username, person));
	}

	@DeleteMapping("/person/{username}")
	public HttpStatus deletePerson(@PathVariable String username) {
		this.personService.deletePerson(username);
		return HttpStatus.OK;
	}
}
