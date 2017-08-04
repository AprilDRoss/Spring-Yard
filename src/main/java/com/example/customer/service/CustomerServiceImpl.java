package com.example.customer.service;


import com.example.customer.Repository.CustomerRepository;
import com.example.customer.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService{
    @Autowired
    CustomerRepository customerRepository;

    @Transactional
    @Override
    public void addCustomer(Customer customer) {

        customerRepository.addCustomer(customer);
    }

    @Override
    public List<Customer> getAllCustomers() {

        return customerRepository.getAllCustomers();
    }
    @Override
    public Customer getCustomerById(int id) {

        return customerRepository.getCustomerById(id);
    }

    @Transactional
    @Override
    public void updateCustomer(Customer customer) {
        customerRepository.updateCustomer(customer);
    }

    @Transactional
    @Override
    public void deleteCustomer(Customer customer) {

        customerRepository.deleteCustomer(customer);
    }
}





