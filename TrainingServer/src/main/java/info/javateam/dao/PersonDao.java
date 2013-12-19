package info.javateam.dao;


import info.javateam.domain.impl.Person;

import java.util.List;

/**
 * @author braunreuther
 *
 */
public interface PersonDao extends AbstractDao<Person>{
	public List<Person> findByCriteria(String firstName, String lastName);
}
