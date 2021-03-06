package com.backend.dao;

import java.io.Serializable;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import com.backend.mode.User;

public class DataDaoImpl implements DataDao {
	 @Autowired
	 SessionFactory sessionFactory;

	 //@Override
	 @Transactional
	 public int insertRow(User user) {
	  Session session = sessionFactory.openSession();
	  Transaction tx = session.beginTransaction();
	  session.saveOrUpdate(user);
	  tx.commit();
	  Serializable id = session.getIdentifier(user);
	  session.close();
	  return (Integer) id;
	 }

	 //@Override
	 public List getList() {
	  Session session = sessionFactory.openSession();
	  @SuppressWarnings("unchecked")
	  List employeeList = session.createQuery("from User")
	    .list();
	  session.close();
	  return employeeList;
	 }

	 //@Override
	 public User getRowById(int id) {
	  Session session = sessionFactory.openSession();
	  User user = (User) session.load(User.class, id);
	  return user;
	 }

	 //@Override
	 public int updateRow(User user) {
	  Session session = sessionFactory.openSession();
	  Transaction tx = session.beginTransaction();
	  session.saveOrUpdate(user);
	  tx.commit();
	  Serializable id = session.getIdentifier(user);
	  session.close();
	  return (Integer) id;
	 }

	 //@Override
	 public int deleteRow(int id) {
	  Session session = sessionFactory.openSession();
	  Transaction tx = session.beginTransaction();
	  User user = (User) session.load(User.class, id);
	  session.delete(user);
	  tx.commit();
	  Serializable ids = session.getIdentifier(user);
	  session.close();
	  return (Integer) ids;
	 }


}
