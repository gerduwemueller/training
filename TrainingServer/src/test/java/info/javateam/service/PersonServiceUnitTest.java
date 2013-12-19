package info.javateam.service;

import info.javateam.domain.impl.Person;

import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;




public class PersonServiceUnitTest {
	
	ApplicationContext ctx1 = new ClassPathXmlApplicationContext("applicationContext.xml");
	PersonService personService = (PersonService) ctx1.getBean("PersonService");
	List<Person> list;
	
	@Before public void before() {
		list = personService.findByCriteria("newUnit", "newTest");
		for(Person person : list)
			personService.delete(person);
		list = personService.findByCriteria("modUnit", "modTest");
		for(Person person : list)
			personService.delete(person);
	}
	@After public void after() {
	}
	
	@Test public void savePerson() {
		list = personService.findByCriteria("newUnit", "newTest");
		Assert.assertTrue(0 == list.size());
		
		Person person = new Person();
		person.setFirstName("newUnit");
		person.setLastName("newTest");
		personService.save(person);

		list = personService.findByCriteria("newUnit", "newTest");
		Assert.assertTrue(1 == list.size());
	}

	@Test public void deletePerson() {
		Person person = new Person();
		person.setFirstName("newUnit");
		person.setLastName("newTest");
		personService.save(person);
		list = personService.findByCriteria("newUnit", "newTest");
		Assert.assertTrue(1 == list.size());
		
		personService.delete(person);
		list = personService.findByCriteria("newUnit", "newTest");
		Assert.assertTrue(0 == list.size());
		
	}
	
	@Test public void updatePerson() {
		Person person = new Person();
		person.setFirstName("newUnit");
		person.setLastName("newTest");
		personService.save(person);
		list = personService.findByCriteria("newUnit", "newTest");
		Assert.assertTrue(1 == list.size());

		person.setFirstName("modUnit");
		person.setLastName("modTest");
		personService.update(person);
		
		list = personService.findByCriteria("newUnit", "newTest");
		Assert.assertTrue(0 == list.size());
		
		list = personService.findByCriteria("modUnit", "modTest");
		Assert.assertTrue(1 == list.size());
	}

}


