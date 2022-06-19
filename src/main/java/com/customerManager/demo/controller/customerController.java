package com.customerManager.demo.controller;

import com.customerManager.demo.dto.customerDto;
import com.customerManager.demo.entities.customer;
import com.customerManager.demo.services.customerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.customerManager.demo.services.*;

import java.util.List;
import java.util.Optional;

@RestController
public class customerController {
    @Autowired
    private customerService customerService;

    @GetMapping("/customers")
    public ResponseEntity<List<customerDto>> getCustomer(){
        List<customerDto> customer = customerService.getCustomers();
        if(customer.size() == 0){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        return ResponseEntity.of(Optional.of(customer)) ;
    }

    @GetMapping("/customer/{id}")
    public ResponseEntity<customerDto> getCustomer(@PathVariable("id") int id) {

        try {
            customerDto c = customerService.getCustomerById(id);
            System.out.println(c.getUserId());
            return ResponseEntity.of(Optional.of(c));
        }
        catch(Exception e){
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PostMapping("/customer")
    public ResponseEntity<customerDto> setCustomer(@RequestBody customerDto c){

        System.out.println(c.toString());

        customerDto nc = customerService.setCustomer(c);
        System.out.println(nc.toString());
        return ResponseEntity.of(Optional.of(nc));

    }
    @PutMapping("/customer/{id}")
    public ResponseEntity<customerDto> updateBook(@PathVariable("id") int id , @RequestBody customerDto c) {
        if (customerService.updateCustomer(id, c) == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();

    }
    //Hard Delete
    @DeleteMapping("/customer/{id}")
    public ResponseEntity<customerDto> deleteCustomer(@PathVariable("id") int id) {

        customerDto deletedCustomer = customerService.deleteCustomer(id);

        if (deletedCustomer == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.of(Optional.of(deletedCustomer));

    }

    @DeleteMapping("/customer/soft/{id}")
    public ResponseEntity<customerDto> SoftdeleteCustomer(@PathVariable("id") int id) {

        customerDto deletedCustomer = customerService.SoftdeleteCustomer(id);

        if (deletedCustomer == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.of(Optional.of(deletedCustomer));

    }







}
