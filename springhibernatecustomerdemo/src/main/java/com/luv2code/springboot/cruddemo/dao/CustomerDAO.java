package com.luv2code.springboot.cruddemo.dao;

import com.luv2code.springboot.cruddemo.entity.Customer;

import java.util.List;

public interface CustomerDAO {

    public List<Customer> findAll();

    public List<Customer> getCustomers();

}
