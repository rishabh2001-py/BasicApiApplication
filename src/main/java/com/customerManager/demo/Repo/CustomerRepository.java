package com.customerManager.demo.Repo;
import com.customerManager.demo.entities.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface CustomerRepository extends CrudRepository<Customer, Integer> {

    List<Customer> findByisActiveTrue();


}
