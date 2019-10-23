package com.darkflame.simplecrudapp.controllers;

import com.darkflame.simplecrudapp.entity.Customer;
import com.darkflame.simplecrudapp.repositories.CustomerRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CustomerController {

    private final CustomerRepository customerRepository;

    public CustomerController(CustomerRepository customerRepository){
        this.customerRepository = customerRepository;
    }

    @GetMapping("/customers")
    public List<Customer> getCustomers(){
        return (List<Customer>) customerRepository.findAll();
    }

}
