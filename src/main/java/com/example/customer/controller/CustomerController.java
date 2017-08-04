package com.example.customer.controller;

import com.example.customer.model.Customer;
import com.example.customer.service.CustomerService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController

public class CustomerController {

    private CustomerService customerService;

    @Autowired
    public CustomerService customerService;

    //Json to Java
    private ObjectMapper objectMapper = new ObjectMapper();

    @GetMapping("/customers")
    public List<Customer> getAllCustomers(Model model) {

        return customerService.getAllCustomers();
    }




}



