package info.javateam.dao.impl;


import info.javateam.dao.AbstractDao;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * @author Sascha
 *
 * @param <T>
 */
public class AbstractDaoImpl<T> extends HibernateDaoSupport implements AbstractDao<T> {

	/* (non-Javadoc)
	 * @see de.dao.AbstractDao#update(java.lang.Object)
	 */
	public void update(T object) {
		getHibernateTemplate().update(object);
	}

	/* (non-Javadoc)
	 * @see de.dao.AbstractDao#save(java.lang.Object)
	 */
	public void save(T object) {
		getHibernateTemplate().save(object);
	}

	/* (non-Javadoc)
	 * @see de.dao.AbstractDao#delete(java.lang.Object)
	 */
	public void delete(T object) {
		getHibernateTemplate().delete(object);
	}
}
