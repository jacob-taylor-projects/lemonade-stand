package com.cooksys.lemonadestand.services;

import com.cooksys.lemonadestand.entities.Customer;
import com.cooksys.lemonadestand.model.CustomerRequestDto;
import com.cooksys.lemonadestand.model.CustomerResponseDto;

import java.util.List;

public interface CustomerService {
    CustomerResponseDto createCustomer(CustomerRequestDto customerRequestDto);

    Customer getCustomer(Long id);

    List<CustomerResponseDto> getAllCustomers();

    CustomerResponseDto getCustomerById(Long id);


    CustomerResponseDto updateCustomer(Long id, CustomerRequestDto customerRequestDto);

    CustomerResponseDto deleteCustomer(Long id);
}
