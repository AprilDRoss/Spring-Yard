package com.example.customer.Repository;


import com.example.customer.model.Customer;

import java.util.List;

public interface CustomerRepository {
    void addCustomer(Customer customer);
    List<Customer>getAllCustomers();
    Customer getCustomerById(int id);
    void updateCustomer(Customer customer);
    void deleteCustomer(int id);
}
