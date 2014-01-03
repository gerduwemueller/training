package info.javateam.service;

import info.javateam.domain.impl.Address;
import info.javateam.services.AddressService;

import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.OptimisticLockingFailureException;



public class AddressServiceUnitTest {
	
	ApplicationContext ctx1 = new ClassPathXmlApplicationContext("applicationContext.xml");
	AddressService addressService = (AddressService) ctx1.getBean("AddressService");
	List<Address> list;
	
	@Before public void before() {
		list = addressService.findByCriteria("newUnitStreet", "newUnitZIP", "newUnitCity");
		for(Address address : list)
			addressService.delete(address);

		list = addressService.findByCriteria("modUnitStreet", "modUnitZIP", "modUnitCity");
		for(Address address : list)
			addressService.delete(address);
	}
	@After public void after() {
	}

	@Test public void saveAdresse() {
		list = addressService.findByCriteria("newUnitStreet", "newUnitZIP", "newUnitCity");
		Assert.assertTrue(0 == list.size());
		
		Address address = new Address();
		address.setStreet("newUnitStreet");
		address.setZip("newUnitZIP");
		address.setCity("newUnitCity");
		addressService.save(address);

		list = addressService.findByCriteria("newUnitStreet", "newUnitZIP", "newUnitCity");
		Assert.assertTrue(1 == list.size());
	}

	@Test public void deleteAdresse() {
		Address address = new Address();
		address.setStreet("newUnitStreet");
		address.setZip("newUnitZIP");
		address.setCity("newUnitCity");
		addressService.save(address);
		
		list = addressService.findByCriteria("newUnitStreet", "newUnitZIP", "newUnitCity");
		Assert.assertTrue(1 == list.size());
		
		addressService.delete(address);
		list = addressService.findByCriteria("newUnitStreet", "newUnitZIP", "newUnitCity");		
		Assert.assertTrue(0 == list.size());
		
	}
	
	@Test public void updateAdresse() {
		Address address = new Address();
		address.setStreet("newUnitStreet");
		address.setZip("newUnitZIP");
		address.setCity("newUnitCity");
		addressService.save(address);
		
		list = addressService.findByCriteria("newUnitStreet", "newUnitZIP", "newUnitCity");		
		Assert.assertTrue(1 == list.size());

		address.setStreet("modUnitStreet");
		address.setZip("modUnitZIP");
		address.setCity("modUnitCity");
		addressService.update(address);
		
		list = addressService.findByCriteria("newUnitStreet", "newUnitZIP", "newUnitCity");
		Assert.assertTrue(0 == list.size());
		
		list = addressService.findByCriteria("modUnitStreet", "modUnitZIP", "modUnitCity");
		Assert.assertTrue(1 == list.size());
	}

	@Test public void modifyBySomeoneElseAdresse() {
		Address address = new Address();
		address.setStreet("newUnitStreet");
		address.setZip("newUnitZIP");
		address.setCity("newUnitCity");
		addressService.save(address);
		
		list = addressService.findByCriteria("newUnitStreet", "newUnitZIP", "newUnitCity");		
		Assert.assertTrue(1 == list.size());
		
		list.get(0).setStreet("modUnitStreet");
		addressService.update(address);

		try {
			address.setVersion(0L);
			list.get(0).setStreet("modUnitStreet2");
			addressService.update(address);
			Assert.fail("OptimisticLockingFailureException expected");
		} catch (OptimisticLockingFailureException e) {
			// TODO: handle exception
		}
	}	
	

}


