package com.darkflame.simplecrudapp.repositories;

import com.darkflame.simplecrudapp.entity.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Long> {
}
