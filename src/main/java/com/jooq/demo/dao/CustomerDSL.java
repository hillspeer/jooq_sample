package com.jooq.demo.dao;

import com.jooq.demo.model.Tables;
import com.jooq.demo.model.tables.pojos.Customers;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerDSL
{

    @Autowired
    private DSLContext dsl;

    public int getCustomerCount(){
        return dsl.fetchCount(Tables.CUSTOMERS);
    }
    public List<Customers> getCustomers(){
        return dsl.selectFrom(Tables.CUSTOMERS).fetch().into(Customers.class);
    }
    public void insert(Customers customer){
        dsl.insertInto(Tables.CUSTOMERS, Tables.CUSTOMERS.CUSTOMERNUMBER, Tables.CUSTOMERS.CUSTOMERNAME,
                Tables.CUSTOMERS.ADDRESSLINE1,Tables.CUSTOMERS.SALESREPEMPLOYEENUMBER, Tables.CUSTOMERS.CITY,
                Tables.CUSTOMERS.CONTACTFIRSTNAME, Tables.CUSTOMERS.CONTACTLASTNAME,
                Tables.CUSTOMERS.COUNTRY, Tables.CUSTOMERS.PHONE, Tables.CUSTOMERS.CREDITLIMIT,
                Tables.CUSTOMERS.POSTALCODE).
                values(customer.getCustomernumber(), customer.getContactfirstname(),customer.getAddressline1(), customer.getSalesrepemployeenumber(),
                customer.getCity(), customer.getContactfirstname(), customer.getContactlastname(), customer.getCountry(), customer.getPhone(),
                        customer.getCreditlimit(), customer.getPostalcode()).execute();
    }
}