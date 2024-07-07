package com.cooksys.lemonadestand.controllers;

import com.cooksys.lemonadestand.model.CustomerRequestDto;
import com.cooksys.lemonadestand.model.CustomerResponseDto;
import com.cooksys.lemonadestand.services.CustomerService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("customers")
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerService customerService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CustomerResponseDto createCustomer(@RequestBody CustomerRequestDto customerRequestDto){
        return customerService.createCustomer(customerRequestDto);
    }

    @GetMapping
    public List<CustomerResponseDto> getAllCustomers(){
        return customerService.getAllCustomers();
    }

    @GetMapping("/{id}")
    public CustomerResponseDto getCustomerById(@PathVariable Long id){
        return customerService.getCustomerById(id);
    }

    @PatchMapping("/{id}")
    public CustomerResponseDto updateCustomer(@PathVariable Long id,@RequestBody CustomerRequestDto customerRequestDto){
        return customerService.updateCustomer(id,customerRequestDto);
    }

    @DeleteMapping("/{id}")
    public CustomerResponseDto deleteCustomer(@PathVariable Long id){
        return customerService.deleteCustomer(id);
    }
}
