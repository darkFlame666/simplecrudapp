package com.darkflame.simplecrudapp.services;

import com.darkflame.simplecrudapp.entity.Customer;
import com.darkflame.simplecrudapp.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;


    @Override
    @Transactional
    public List<Customer> findAll() {
        return (List<Customer>) customerRepository.findAll();
    }

    @Override
    public Customer findById(Long theId) {
        Optional<Customer> result = customerRepository.findById(theId);
        Customer theCustomer = null;
        if(result.isPresent()){
            theCustomer = result.get();
        }
        else{
            throw new RuntimeException("Dud not find customer id - ");
        }
        return theCustomer;
    }

    @Override
    public void save(Customer theCustomer) {
        customerRepository.save(theCustomer);
    }


    @Override
    @Transactional
    public void deleteById(Long theId) {
        customerRepository.deleteById(theId);
    }
}
