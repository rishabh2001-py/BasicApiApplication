package com.customerManager.demo.Repo;
import com.customerManager.demo.entities.customer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface CustomerRepository extends CrudRepository<customer, Integer> {

    List<customer> findByisActiveTrue();

}
