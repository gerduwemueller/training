package info.javateam.dao.impl;

import info.javateam.dao.PersonDao;
import info.javateam.domain.impl.Person;

import java.util.ArrayList;
import java.util.List;


public class PersonDaoImpl extends AbstractDaoImpl<Person> implements PersonDao {
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Person> findByCriteria(String vorname, String nachname) {
		List<String> arguments = new ArrayList<String>();
		String sql = null;
		if(vorname    != null) { arguments.add(vorname);    sql = (sql == null)? "where firstName=? " : sql + " and firstName=?"; }
		if(nachname   != null) { arguments.add(nachname);   sql = (sql == null)? "where lastName=?  " : sql + " and lastName=?";  }
		if(sql == null) sql = "";
		
		return (List<Person>) getHibernateTemplate().find("from Person " + sql, arguments.toArray()); 
	}	


}