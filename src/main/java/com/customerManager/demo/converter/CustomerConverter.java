package com.customerManager.demo.converter;

import com.customerManager.demo.dto.CustomerDto;
import com.customerManager.demo.entities.Customer;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CustomerConverter {

    public List<CustomerDto> entityToDto(List<Customer> allCustomers){
        return allCustomers.stream().map(this::entityToDto).collect(Collectors.toList());
    }
    public CustomerDto entityToDto(Customer c){
            CustomerDto custDto = new CustomerDto();
            custDto.setUserId(c.getId());
            custDto.setFirstName(c.getFirstName());
//            custDto.setLastName(c.getLastName());
            custDto.setAge(c.getAge());
            custDto.setGender(c.getGender());

        return custDto;
    }
    public List<Customer> DtoToEntity(List<CustomerDto> CustomerDtos){

        return CustomerDtos.stream().map(this::DtoToEntity).collect(Collectors.toList());

    }

    public Customer DtoToEntity(CustomerDto c){

            Customer customerEnt = new Customer();
            customerEnt.setId(c.getUserId());
            customerEnt.setFirstName(c.getFirstName());
//            customerEnt.setLastName(c.getLastName());
            customerEnt.setAge(c.getAge());
            customerEnt.setGender(c.getGender());
            customerEnt.setActive(true);

        return customerEnt;
    }

}
