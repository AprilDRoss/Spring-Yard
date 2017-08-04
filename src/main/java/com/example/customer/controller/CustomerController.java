package com.example.customer.controller;

import com.example.customer.model.Customer;
import com.example.customer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
@RestController

public class CustomerController {
    private CustomerService customerService;

    @Autowired
    public CustomerService customerService;

    //Json to Java
    private ObjectMapper objectMapper = new ObjectMapper();

    //return all customers in database
    @RequestMapping("/")
    public String home(){
        return "home";
    }

    @RequestMapping("/customers")
    public String customerList(Model model){
        model.addAttribute("customers", customerService.getAllCustomers());
        return "customers";
    }

    @RequestMapping("/customers/{id}")
    public String getCustomerById(@PathVariable String id, Model model){
        model.addAttribute("customers", customerService.getCustomerById(int id));
        return "/customers/id";
    }

    @RequestMapping(value="/addcustomers", method = RequestMethod.POST)
    public String addCustomer(@Valid Customer customer, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "addcustomers";
        }
        Customer savedCustomer = customerService.addCustomer(customer);
        return "redirect:/customers";
    }



}



