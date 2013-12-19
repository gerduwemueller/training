package info.javateam.service;

import info.javateam.domain.impl.Address;

import java.util.List;


/**
 * @author braunreuther
 *
 */
public interface AddressService extends AbstractService<Address> {
	/**
	 * Search an address null skips a criteria
	 * TODO replace with Hash and Enum
	 * @param street
	 * @param zip
	 * @param city
	 * @return
	 */
	public List<Address> findByCriteria(String street, String zip, String city);
}
