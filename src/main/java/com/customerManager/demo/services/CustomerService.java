package com.customerManager.demo.services;

import com.customerManager.demo.Repo.CustomerRepository;
import com.customerManager.demo.dto.CustomerDto;
import com.customerManager.demo.entities.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.customerManager.demo.converter.*;
import java.util.List;
import java.util.Optional;


@Service
public class CustomerService {

    @Autowired
    private CustomerRepository custRepo;
    @Autowired
    private CustomerConverter customerConverter;

    public List<CustomerDto> getCustomers() {
        List<Customer> allcustomers = custRepo.findByisActiveTrue();
        return customerConverter.entityToDto(allcustomers);

    }

    public CustomerDto getCustomerById(int id) {
        Optional<Customer> foundCustomer = custRepo.findById(id);
        if (foundCustomer.isPresent() && (foundCustomer.get().getActive())) {
            return customerConverter.entityToDto(foundCustomer.get());
        }
        return null;
    }

    public CustomerDto setCustomer(CustomerDto c) {
        Customer nc = customerConverter.DtoToEntity(c);
        Customer new_c = custRepo.save(nc);
        return customerConverter.entityToDto(new_c);
    }

    public CustomerDto updateCustomer(int id, CustomerDto c) {
        Optional<Customer> updatedBook = custRepo.findById(id);
        if (updatedBook.isPresent() && (updatedBook.get().getActive())) {
            return customerConverter.entityToDto(custRepo.save(customerConverter.DtoToEntity(c)));
        }
        return null;
    }

    public CustomerDto deleteCustomer(int id) {
        try {
            Optional<Customer> dc = custRepo.findById(id);
            custRepo.deleteById(id);
            CustomerDto cdto = customerConverter.entityToDto(dc.get());
            return cdto;
        } catch (Exception e) {
            return null;
        }
    }

    public CustomerDto softDeleteCustomer(int id) {
        try {
             Customer c = custRepo.findById(id).get();
             c.setActive(false);
             custRepo.save(c);
            return customerConverter.entityToDto(c);
        } catch (Exception e) {
            return null;
        }
    }
}
