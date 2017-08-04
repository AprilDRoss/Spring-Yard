package com.example.customer.service;

import com.example.customer.model.Customer;

import java.util.List;

public interface CustomerService {
    Customer addCustomer(Customer customer);
    List<Customer>getAllCustomers();
    Customer getCustomerById(int id);
    Customer updateCustomer(Customer customer);
    Customer deleteCustomer(Customer customer);
}
