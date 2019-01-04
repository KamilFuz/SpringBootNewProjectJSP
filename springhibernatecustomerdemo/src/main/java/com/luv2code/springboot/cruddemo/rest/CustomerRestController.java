package com.luv2code.springboot.cruddemo.rest;

import com.luv2code.springboot.cruddemo.dao.CustomerDAO;
import com.luv2code.springboot.cruddemo.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//@RestController
@Controller
@RequestMapping("/api")
public class CustomerRestController {

    private CustomerDAO customerDAO;

    @Autowired
    public CustomerRestController(CustomerDAO customerDAO) {
        this.customerDAO = customerDAO;
    }

    @GetMapping("/customers")
    public List<Customer> findAll() {
        return customerDAO.findAll();
    }

    @RequestMapping("customer")
    public String customer() {
        return "list";
    }

}
