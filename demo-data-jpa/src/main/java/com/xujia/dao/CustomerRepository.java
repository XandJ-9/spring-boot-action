package com.xujia.dao;

import com.xujia.entity.Customer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

    @Query(value = "select * from customers", nativeQuery = true)
    public List<Customer> findAll();

    @Query(value = "select first_Name from customers", nativeQuery = true)
    public List<Object[]> findFirstName();

    public Customer findById(long id);
}
