package com.luv2code.springboot.cruddemo.dao;

import com.luv2code.springboot.cruddemo.entity.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository
public class CustomerDAOHibernateImpl implements CustomerDAO{

    private EntityManager entityManager;

    private SessionFactory sessionFactory;

    @Autowired
    public CustomerDAOHibernateImpl (EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public List<Customer> findAll() {

        Session currentSession = entityManager.unwrap(Session.class);

//        Query<Customer> theQuery = currentSession.createQuery("from Customer", Customer.class);
        org.hibernate.query.Query<Customer> theQuery =
                currentSession.createQuery("from Customer", Customer.class);

        List<Customer> customers = theQuery.getResultList();
        return customers;
    }

    @Override
    @Transactional
    public List<Customer> getCustomers() {

        Session currentSession = entityManager.unwrap(Session.class);
//        Session currentSession = sessionFactory.getCurrentSession();

        org.hibernate.query.Query<Customer> theQuery =
                currentSession.createQuery("from Customer", Customer.class);

        List<Customer> customers = theQuery.getResultList();
        return customers;

    }
}
