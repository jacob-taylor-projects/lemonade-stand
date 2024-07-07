package com.cooksys.lemonadestand.services.impl;

import com.cooksys.lemonadestand.entities.Customer;
import com.cooksys.lemonadestand.exceptions.BadRequestException;
import com.cooksys.lemonadestand.exceptions.NotFoundException;
import com.cooksys.lemonadestand.mappers.CustomerMapper;
import com.cooksys.lemonadestand.model.CustomerRequestDto;
import com.cooksys.lemonadestand.model.CustomerResponseDto;
import com.cooksys.lemonadestand.repos.CustomerRepo;
import com.cooksys.lemonadestand.services.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepo customerRepo;
    private final CustomerMapper customerMapper;

    private void validateCustomerRequest(CustomerRequestDto customerRequestDto){
      if (customerRequestDto==null||customerRequestDto.getName()==null||customerRequestDto.getPhoneNumber()==null){
          throw new BadRequestException("Please provide a name and phoneNumber");
      }
    }

    @Override
    public Customer getCustomer(Long id){
       Optional<Customer> potentialCustomer=customerRepo.findById(id);
       if (potentialCustomer.isEmpty()){
           throw new NotFoundException("Could not find customer with id"+id);
       }
       Customer customer=potentialCustomer.get();
       return customer;
    }

    @Override
    public CustomerResponseDto createCustomer(CustomerRequestDto customerRequestDto) {
       validateCustomerRequest(customerRequestDto);
       Customer customer=customerMapper.requestDtoToEntity(customerRequestDto);
       customerRepo.saveAndFlush(customer);
       return customerMapper.entityToResponseDto(customer);
    }

    @Override
    public List<CustomerResponseDto> getAllCustomers() {
       return customerMapper.entitiesToResponseDtos(customerRepo.findAll());

    }

    @Override
    public CustomerResponseDto getCustomerById(Long id) {
       return customerMapper.entityToResponseDto(getCustomer(id));
    }

    @Override
    public CustomerResponseDto updateCustomer(Long id, CustomerRequestDto customerRequestDto) {
        Customer customer=getCustomer(id);
      if (customerRequestDto.getName()!=null){
          customer.setName(customerRequestDto.getName());
      }
      if (customerRequestDto.getPhoneNumber()!=null){
          customer.setPhoneNumber(customer.getPhoneNumber());
      }
      customerRepo.saveAndFlush(customer);
      return customerMapper.entityToResponseDto(customer);
    }

    @Override
    public CustomerResponseDto deleteCustomer(Long id) {
       Customer customer=getCustomer(id);
       customerRepo.delete(customer);
       return customerMapper.entityToResponseDto(customer);
    }
}
