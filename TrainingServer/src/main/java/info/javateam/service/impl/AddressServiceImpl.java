package info.javateam.service.impl;


import info.javateam.dao.AddressDao;
import info.javateam.domain.impl.Address;
import info.javateam.service.AddressService;

import java.util.List;


/**
 * @author Sascha
 *
 */
public class AddressServiceImpl implements AddressService {
	private AddressDao addressDao;

	/**
	 * Sets the dao for databaseAccess
	 * @param addressDao
	 */
	public void setAddressDao(AddressDao addressDao) {
		this.addressDao = addressDao;
	}

	/**
	 * Gets the dao for databaseAccess
	 * @return
	 */
	public AddressDao getAddressDao() {
		return addressDao;
	}

	/* (non-Javadoc)
	 * @see de.service.AbstractService#save(java.lang.Object)
	 */
	@Override
	public void save(Address address) {
		addressDao.save(address);
		
	}

	/* (non-Javadoc)
	 * @see de.service.AbstractService#update(java.lang.Object)
	 */
	@Override
	public void update(Address address) {
		addressDao.update(address);
	}

	/* (non-Javadoc)
	 * @see de.service.AbstractService#delete(java.lang.Object)
	 */
	@Override
	public void delete(Address address) {
		addressDao.delete(address);
	}

	/* (non-Javadoc)
	 * @see de.service.AddressService#findByCriteria(java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public List<Address> findByCriteria(String street, String zip, String city) {
		return addressDao.findByCriteria(street, zip, city);
	}
}



