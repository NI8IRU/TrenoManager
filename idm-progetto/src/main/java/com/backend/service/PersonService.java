package com.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.dao.PersonDAO;
import com.backend.model.Person;

@Service
public class PersonService {

	@Autowired
	PersonDAO personDAO;

	public void addPerson(Person person) {
		personDAO.addPerson(person);
	}

	public List<Person> getAllPerson() {
		return personDAO.getAllPerson();
	}

	public Person getById(Long id) {
		return personDAO.getPersonById(id);
	}

	public void updatePerson(Person person) {
		personDAO.updatePerson(person);
	}

	public void deletePerson(Long id) {
		personDAO.deletePerson(id);
	}
}
