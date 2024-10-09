package com.xujia.controller;

import com.xujia.dao.CustomerRepository;
import com.xujia.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    CustomerRepository repository;
    @GetMapping("/customers/")
    public List<Customer> getCustomer(){
        List<Customer> customers = repository.findAll();
        return customers;
    }

    @GetMapping("/firstnames/")
    public List<Object[]> getFirstName(){
        List<Object[]> list = repository.findFirstName();
        return list;
    }


    @GetMapping("/customers/{id}")
    public Customer getCustomerById(@PathVariable("id") Integer id){
        Customer customer = repository.findById(id);
        return customer;
    }

    @GetMapping("/customers/save")
    public String saveCustomer(){
        Customer c1 = new Customer("Jobs", "Steven");
        repository.save(c1);
        return "添加成功";
    }

}
