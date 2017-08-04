package com.example.customer.Repository;


import com.example.customer.model.Customer;

import java.util.List;

public interface CustomerRepository {
    public void addCustomer(Customer customer);
    public List<Customer>getAllCustomers();
    public Customer getCustomerById(int id);
    public void updateCustomer(Customer customer);
    public void deleteCustomer(Customer customer);

}
