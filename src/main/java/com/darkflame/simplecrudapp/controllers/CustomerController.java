package com.darkflame.simplecrudapp.controllers;

import com.darkflame.simplecrudapp.entity.Customer;
import com.darkflame.simplecrudapp.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CustomerController {

    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/customers")
    public List<Customer> findAll(){
        return customerService.findAll();
    }

    @GetMapping("/customers/{customerId}")
    public Customer getCustomer(@PathVariable Long customerId){
        Customer theCustomer = customerService.findById(customerId);
        if(theCustomer == null)
            throw new RuntimeException("Customer id not found - "+customerId);
        return theCustomer;
    }

    @PostMapping("/customers")
    public Customer addCustomer(@RequestBody Customer theCustomer){
        theCustomer.setId(0L);
        customerService.save(theCustomer);
        return theCustomer;
    }

    @PutMapping("/customers")
    public Customer updateCustomer(@RequestBody Customer theCustomer){
        customerService.save(theCustomer);
        return theCustomer;
    }

    @DeleteMapping("customers/{customerId}")
    public String deleteCustomer(@PathVariable Long customerId){
        Customer tempCustomer = customerService.findById(customerId);
        if(tempCustomer == null) {
            throw new RuntimeException("Customer id not found - " + customerId);
        }
        customerService.deleteById(customerId);
        return "Deleted customer id - "+customerId;
    }



}
