package info.javateam.dao;


import info.javateam.domain.impl.Address;

import java.util.List;

/**
 * @author braunreuther
 *
 */
public interface AddressDao extends AbstractDao<Address>{

	/**
	 * 
	 * 
	 * @param street
	 * @param zip
	 * @param city
	 * @return
	 */
	public List<Address> findByCriteria(String street, String zip, String city);
}
