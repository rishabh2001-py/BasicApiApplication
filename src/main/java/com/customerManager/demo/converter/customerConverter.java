package com.customerManager.demo.converter;

import com.customerManager.demo.dto.customerDto;
import com.customerManager.demo.entities.customer;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class customerConverter {

    public List<customerDto> entityToDto(List<customer> allCustomers){
        return allCustomers.stream().map(this::entityToDto).collect(Collectors.toList());
    }
    public customerDto entityToDto(customer c){
            customerDto custDto = new customerDto();
            custDto.setUserId(c.getId());
            custDto.setFirstName(c.getFirstName());
            custDto.setLastName(c.getLastName());
            custDto.setAge(c.getAge());
            custDto.setGender(c.getGender());

        return custDto;
    }
    public List<customer> DtoToEntity(List<customerDto> customerDtos){

        return customerDtos.stream().map(this::DtoToEntity).collect(Collectors.toList());

    }

    public customer DtoToEntity(customerDto c){

            customer customerEnt = new customer();
            customerEnt.setId(c.getUserId());
            customerEnt.setFirstName(c.getFirstName());
            customerEnt.setLastName(c.getLastName());
            customerEnt.setAge(c.getAge());
            customerEnt.setGender(c.getGender());
            customerEnt.setActive(true);

        return customerEnt;
    }

}
