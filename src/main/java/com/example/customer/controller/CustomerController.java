package com.example.customer.controller;

import com.example.customer.model.Customer;
import com.example.customer.service.CustomerService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController

public class CustomerController {

    @Autowired
    private CustomerService customerService;

    //Json to Java
    private ObjectMapper objectMapper = new ObjectMapper();

    @GetMapping("/customers")
    public List<Customer> getAllCustomers(Model model) {
        return customerService.getAllCustomers();
    }

    @PostMapping(value = "/addcustomers")
    public void addCustomer(@RequestBody Customer customer){
        customerService.addCustomer(customer);
        return "addcustomers";
    }






}



