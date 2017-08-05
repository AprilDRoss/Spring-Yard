package com.example.customer.controller;

import com.example.customer.model.Customer;
import com.example.customer.service.CustomerService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@Controller

public class CustomerController {

    @Autowired
    CustomerService customerService;

    //Json to Java
    private ObjectMapper objectMapper = new ObjectMapper();

    @RequestMapping("/home")
    public String getHome(){
        return "home";
    }

    @RequestMapping("/customers")
    public List<Customer> getAllCustomers(Model model) {

        return customerService.getAllCustomers();
    }

    @RequestMapping("/addcustomers")
    public String addCustomers(@RequestParam(value="firstName")String firstName,
                              @RequestParam(value="lastName")String lastName,
                              @RequestParam(value="phone") String phone,
                              @RequestParam(value="email")String email,
                              Model model){
        Customer customer = new Customer();
        customer.setFirstName(firstName);
        customer.setLastName(lastName);
        customer.setPhone(phone);
        customer.setEmail(email);
        customerService.addCustomer(customer);
        return "redirect: /viewcustomers";
    }

    @RequestMapping("/viewcustomers/{id}")
    public String getCustomerById(@PathVariable int id, Model model){
        Customer customer = customerService.getCustomerById(id);
        model.addAttribute("customers", customer);
        return "viewcustomers";
    }

}



