package info.javateam.dao.impl;

import info.javateam.dao.AddressDao;
import info.javateam.domain.impl.Address;

import java.util.ArrayList;
import java.util.List;


public class AddressDaoImpl extends AbstractDaoImpl<Address> implements AddressDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<Address> findByCriteria(String street, String zip, String city) {
		List<String> arguments = new ArrayList<String>();
		String sql = null;
		if(street != null) { arguments.add(street); sql = (sql == null)? "where street=? " : sql + " and street=?"; }
		if(zip    != null) { arguments.add(zip);    sql = (sql == null)? "where zip=? "    : sql + " and zip=?";    }
		if(city   != null) { arguments.add(city);   sql = (sql == null)? "where city=? "   : sql + " and city=?";   }
		if(sql == null) sql = "";
		
		return (List<Address>) getHibernateTemplate().find("from Address " + sql, arguments.toArray()); 
	}	
}