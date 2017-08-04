package com.example.customer.common;

import com.example.customer.model.Customer;

import java.util.List;
import java.util.Random;

public class CustomerUtils {

    private static Random random = new Random();

    public static Customer createTestCustomer() {
        // Get unique names every time this test runs
        String firstName = Long.toString(System.currentTimeMillis());
        String lastName = Long.toString(System.currentTimeMillis());
        String phone = Long.toString(System.currentTimeMillis());
        String email = Long.toString(System.currentTimeMillis());

        Customer customer = new Customer();
        customer.setFirstName(firstName);
        customer.setLastName(lastName);
        customer.setPhone(phone);
        customer.setEmail(email);

        return customer;
    }

    public static Customer findInList(List<Customer> customer, String first, String last, String cell, String webcontact) {
        // Find the new person in the list
        boolean found = false;
        for (Customer customers : customer) {
            if (customers.getFirstName().equals(first) && customers.getLastName().equals(last) && customers.getPhone().equals(cell) && customers.getEmail().equals(webcontact)) {
                return customers;
            }
        }
        return null;
    }
}
