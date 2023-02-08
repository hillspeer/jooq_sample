package com.jooq.demo;

import com.jooq.demo.dao.CustomerDSL;
import com.jooq.demo.model.tables.pojos.Customers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    CustomerDSL customerDsl;

    @GetMapping
    public int getCustomerCount(){
        return customerDsl.getCustomerCount();
    }

    @GetMapping(path = "/customers", produces = "application/json")
    public List<Customers> getCustomers(){
        return customerDsl.getCustomers();
    }

    @PostMapping(consumes = "application/json")
    public void postBook(@RequestBody Customers customer){
        customerDsl.insert(customer);
    }
}
