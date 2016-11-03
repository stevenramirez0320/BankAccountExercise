package com.conex.bank.dao;

import javax.inject.Inject;

import org.hibernate.LockOptions;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Qualifier;

@SuppressWarnings("unchecked")
public class BaseDao {

	@Inject
	@Qualifier("masterSessionFactory")
	protected SessionFactory sessionFactory;

	public <T> T get(Session session, Class<T> clazz, Long id) {
        return (T) session.get(clazz, id, LockOptions.UPGRADE);
    }
	
	public void update(Session session, Object object) {
		session.update(object);
    }
}
