package com.cooksys.lemonadestand.mappers;

import com.cooksys.lemonadestand.entities.Customer;
import com.cooksys.lemonadestand.model.CustomerDto;
import com.cooksys.lemonadestand.model.CustomerRequestDto;
import com.cooksys.lemonadestand.model.CustomerResponseDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CustomerMapper {
    Customer requestDtoToEntity(CustomerRequestDto customerRequestDto);

    Customer customerDtoToEntity(CustomerDto customerDto);

    CustomerResponseDto entityToResponseDto(Customer customer);

    List<CustomerResponseDto> entitiesToResponseDtos(List<Customer> customers);
}
