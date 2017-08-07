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

    @RequestMapping(value ="/home")
    public String getHome(){
        return "home";
    }

    @RequestMapping(value = "/customers", method=RequestMethod.GET)
    public List<Customer> getAllCustomers(Model model) {

        return customerService.getAllCustomers();
    }

    @RequestMapping(value="/addcustomers", method = RequestMethod.GET)
    public String getAddCustomers(){
        return "addcustomers";
    }

    @RequestMapping(value = "/addcustomers", method =  RequestMethod.POST)
    public String addCustomers(@RequestParam(value="firstname")String firstName,
                              @RequestParam(value="lastname")String lastName,
                              @RequestParam(value="phone") String phone,
                              @RequestParam(value="email")String email,
                              Model model){
        Customer customer = new Customer();
        customer.setFirstname(firstName);
        customer.setLastname(lastName);
        customer.setPhone(phone);
        customer.setEmail(email);
        customerService.addCustomer(customer);
        return "redirect:/customers";
    }

    @RequestMapping(value= "/viewcustomers/{id}", method = RequestMethod.GET)
    public String getCustomerById(@PathVariable int id, Model model){
        Customer customer = customerService.getCustomerById(id);
        model.addAttribute("customers", customer);
        return "viewcustomers";
    }

}



