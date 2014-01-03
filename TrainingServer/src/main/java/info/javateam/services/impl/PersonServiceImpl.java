package info.javateam.services.impl;


import info.javateam.dao.PersonDao;
import info.javateam.domain.impl.Person;
import info.javateam.services.PersonService;

import java.util.List;


/**
 * @author Sascha
 *
 */
public class PersonServiceImpl implements PersonService {

	private PersonDao personDao;

	/**
	 * Sets the dao for databaseAccess
	 */
	public void setPersonDao(PersonDao personDao) {
		this.personDao = personDao;
	}

	/**
	 * Gets the dao for databaseAccess
	 * @return
	 */
	public PersonDao getPersonDao() {
		return personDao;
	}

	/* (non-Javadoc)
	 * @see de.service.AbstractService#save(java.lang.Object)
	 */
	@Override
	public void save(Person person) {
		personDao.save(person);
		
	}

	/* (non-Javadoc)
	 * @see de.service.AbstractService#update(java.lang.Object)
	 */
	@Override
	public void update(Person person) {
		personDao.update(person);
	}

	/* (non-Javadoc)
	 * @see de.service.AbstractService#delete(java.lang.Object)
	 */
	@Override
	public void delete(Person person) {
		personDao.delete(person);
	}

	/* (non-Javadoc)
	 * @see de.service.PersonService#findByCriteria(java.lang.String, java.lang.String)
	 */
	@Override
	public List<Person> findByCriteria(String fistName, String lastName) {
		return personDao.findByCriteria(fistName, lastName);
	}


}



