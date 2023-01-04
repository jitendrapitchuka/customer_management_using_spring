package com.demo.springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.demo.springdemo.entity.Customer;

//dao implemenation
@Repository
public class CustomerDaoImpl implements CustomerDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	
	@Override
	@Transactional
	public List<Customer> getCustomers() {
		
		Session currentSession=sessionFactory.getCurrentSession();
		
		Query<Customer> theQuery=currentSession.createQuery("from Customer",Customer.class);
		
		List<Customer> customers=theQuery.getResultList();
		
		
		return customers;
	}

}
