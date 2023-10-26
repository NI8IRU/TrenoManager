package com.backend.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.backend.model.Person;

@Component
public class PersonDAO {

	@Autowired
	HibernateTemplate hibernateTemplate;

	@Transactional
	public void addPerson(Person person) {
		hibernateTemplate.save(person);
	}

	public List<Person> getAllPerson() {
		return hibernateTemplate.loadAll(Person.class);
	}

	@Transactional
	public Person getPersonById(Long id) {

		Person person = hibernateTemplate.get(Person.class, id);
		return person;
	}

	@Transactional
	public void updatePerson(Person person) {
		hibernateTemplate.update(person);
	}

	@Transactional
	public void deletePerson(Long id) {
		hibernateTemplate.delete(hibernateTemplate.load(Person.class, id));
	}
}
