package com.customerManager.demo.controller;

import com.customerManager.demo.dto.CustomerDto;
import com.customerManager.demo.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping("/customers")
    public ResponseEntity<List<CustomerDto>> getCustomer(){
        List<CustomerDto> customer = customerService.getCustomers();
        if(customer.size() == 0){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        return ResponseEntity.of(Optional.of(customer)) ;
    }

    @GetMapping("/customer/{id}")
    public ResponseEntity<CustomerDto> getCustomer(@PathVariable("id") int id) {

        try {
            CustomerDto c = customerService.getCustomerById(id);
            System.out.println(c.getUserId());
            return ResponseEntity.of(Optional.of(c));
        }
        catch(Exception e){
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PostMapping("/customer")
    public ResponseEntity<CustomerDto> setCustomer(@RequestBody CustomerDto c){

        CustomerDto nc = customerService.setCustomer(c);
        System.out.println(nc.toString());
        return ResponseEntity.of(Optional.of(nc));

    }
    @PutMapping("/customer/{id}")
    public ResponseEntity<CustomerDto> updateBook(@PathVariable("id") int id , @RequestBody CustomerDto c) {
        if (customerService.updateCustomer(id, c) == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();

    }
    //Hard Delete
    @DeleteMapping("/customer/{id}")
    public ResponseEntity<CustomerDto> deleteCustomer(@PathVariable("id") int id) {

        CustomerDto deletedCustomer = customerService.deleteCustomer(id);

        if (deletedCustomer == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.of(Optional.of(deletedCustomer));

    }

    @PutMapping ("/customer/soft/{id}")
    public ResponseEntity<CustomerDto> SoftdeleteCustomer(@PathVariable("id") int id) {

        CustomerDto deletedCustomer = customerService.softDeleteCustomer(id);

        if (deletedCustomer == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.of(Optional.of(deletedCustomer));

    }







}
