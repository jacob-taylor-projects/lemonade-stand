package com.cooksys.lemonadestand.mappers;

import com.cooksys.lemonadestand.entities.Customer;
import com.cooksys.lemonadestand.model.CustomerDto;
import com.cooksys.lemonadestand.model.CustomerRequestDto;
import com.cooksys.lemonadestand.model.CustomerResponseDto;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-06-17T17:16:51-0500",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 22.0.1 (Oracle Corporation)"
)
@Component
public class CustomerMapperImpl implements CustomerMapper {

    @Override
    public Customer requestDtoToEntity(CustomerRequestDto customerRequestDto) {
        if ( customerRequestDto == null ) {
            return null;
        }

        Customer customer = new Customer();

        customer.setName( customerRequestDto.getName() );
        customer.setPhoneNumber( customerRequestDto.getPhoneNumber() );

        return customer;
    }

    @Override
    public Customer customerDtoToEntity(CustomerDto customerDto) {
        if ( customerDto == null ) {
            return null;
        }

        Customer customer = new Customer();

        customer.setId( customerDto.getId() );

        return customer;
    }

    @Override
    public CustomerResponseDto entityToResponseDto(Customer customer) {
        if ( customer == null ) {
            return null;
        }

        CustomerResponseDto customerResponseDto = new CustomerResponseDto();

        customerResponseDto.setId( customer.getId() );
        customerResponseDto.setName( customer.getName() );
        customerResponseDto.setPhoneNumber( customer.getPhoneNumber() );

        return customerResponseDto;
    }

    @Override
    public List<CustomerResponseDto> entitiesToResponseDtos(List<Customer> customers) {
        if ( customers == null ) {
            return null;
        }

        List<CustomerResponseDto> list = new ArrayList<CustomerResponseDto>( customers.size() );
        for ( Customer customer : customers ) {
            list.add( entityToResponseDto( customer ) );
        }

        return list;
    }
}
