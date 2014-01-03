package info.javateam.services;

import info.javateam.domain.impl.Person;

import java.util.List;

/**
 * @author braunreuther
 *
 */
/**
 * @author Sascha
 *
 */
public interface PersonService extends AbstractService<Person>{
	/**
	 * Search a person null skips a criteria
	 * TODO replace with Hash and Enum
	 * @param firstName
	 * @param lastName
	 * @return
	 */
	public List<Person> findByCriteria(String firstName, String lastName);
}
