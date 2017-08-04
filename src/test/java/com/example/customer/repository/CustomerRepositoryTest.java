package com.example.customer.repository;

import com.example.customer.Repository.CustomerRepository;
import com.example.customer.model.Customer;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static com.example.customer.common.CustomerUtils.findInList;

public class CustomerRepositoryTest {

    @RunWith(SpringRunner.class)
    @SpringBootTest
    public class PersonRepositoryTest {

        @Autowired
        CustomerRepository customerRepository;

        @Test
        public void testAddGet() {
            // Get unique names every time this test runs
            String firstName = Long.toString(System.currentTimeMillis());
            String lastName = Long.toString(System.currentTimeMillis());
            String email = Long.toString(System.currentTimeMillis());
            String phone = Long.toString(System.currentTimeMillis());


            Customer customer1 = new Customer();
            customer1.setFirstName(firstName);
            customer1.setLastName(lastName);
            customer1.setEmail(email);
            customer1.setPhone(phone);
            customerRepository.addCustomer(customer1);

            List<Customer> getAllCustomers = customerRepository.getAllCustomers();

            Customer person2 = findInList(getAllCustomers, firstName, lastName, email, phone);
            Assert.assertNotNull(person2);

            Customer person3 = customerRepository.getCustomerById(person2.getId());
            Assert.assertNotNull(person3);
            Assert.assertEquals(firstName, person3.getFirstName());
            Assert.assertEquals(lastName, person3.getLastName());
        }
    }
}



