package com.customerManager.demo.services;


import com.customerManager.demo.Repo.CustomerRepository;
import com.customerManager.demo.converter.customerConverter;
import com.customerManager.demo.dto.customerDto;
import com.customerManager.demo.entities.customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import com.customerManager.demo.converter.*;
import java.util.List;
import java.util.Optional;


@Service
public class customerService {

    @Autowired
    private CustomerRepository custRepo;
    @Autowired
    private customerConverter customerConverter;

    public List<customerDto> getCustomers() {
        List<customer> allcustomers = (List<customer>) custRepo.findByisActiveTrue();
        List<customerDto> dtoCustomers = customerConverter.entityToDto(allcustomers);

        return dtoCustomers;

    }

    public customerDto getCustomerById(int id) {
        Optional<customer> foundCustomer = custRepo.findById(id);
        if (foundCustomer.isPresent()) {
            return customerConverter.entityToDto(foundCustomer.get());
        }
        return null;
    }

    public customerDto setCustomer(customerDto c) {

        customer nc = customerConverter.DtoToEntity(c);
        System.out.println(nc.getLastName());
        customer new_c = custRepo.save(nc);
        customerDto new_dto = customerConverter.entityToDto(new_c);
        return new_dto;


    }

    public customerDto updateCustomer(int id, customerDto c) {
        Optional<customer> updatedBook = custRepo.findById(id);
        if (updatedBook.isPresent()) {
            customer uc = customerConverter.DtoToEntity(c);
            custRepo.save(uc);
            return customerConverter.entityToDto(uc);
        }

        return null;
    }

    public customerDto deleteCustomer(int id) {
        try {
            Optional<customer> dc = custRepo.findById(id);
            custRepo.deleteById(id);
            customerDto dcdto = customerConverter.entityToDto(dc.get());
            return dcdto;

        } catch (Exception e) {
            return null;

        }
    }

    public customerDto SoftdeleteCustomer(int id) {

        try {
            Optional<customer> dc = custRepo.findById(id);
            customer c = dc.get();
            c.setActive(false);
            System.out.println(c.getActive());
            customerDto dcDto = customerConverter.entityToDto(dc.get());
            return dcDto;
        } catch (Exception e) {
            return null;
        }
    }
}
