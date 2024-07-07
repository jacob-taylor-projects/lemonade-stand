package com.cooksys.lemonadestand.mappers;

import com.cooksys.lemonadestand.entities.Lemonade;
import com.cooksys.lemonadestand.entities.Order;
import com.cooksys.lemonadestand.model.LemonadeDto;
import com.cooksys.lemonadestand.model.OrderRequestDto;
import com.cooksys.lemonadestand.model.OrderResponseDto;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-06-17T17:16:50-0500",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 22.0.1 (Oracle Corporation)"
)
@Component
public class OrderMapperImpl implements OrderMapper {

    @Autowired
    private CustomerMapper customerMapper;
    @Autowired
    private LemonadeStandMapper lemonadeStandMapper;
    @Autowired
    private LemonadeMapper lemonadeMapper;

    @Override
    public Order requestDtoToEntity(OrderRequestDto orderRequestDto) {
        if ( orderRequestDto == null ) {
            return null;
        }

        Order order = new Order();

        order.setLemonades( lemonadeDtoListToLemonadeList( orderRequestDto.getLemonades() ) );
        order.setCustomer( customerMapper.customerDtoToEntity( orderRequestDto.getCustomer() ) );
        order.setLemonadeStand( lemonadeStandMapper.lemonadeStandDtoToEntity( orderRequestDto.getLemonadeStand() ) );

        return order;
    }

    @Override
    public OrderResponseDto entityToResponseDto(Order order) {
        if ( order == null ) {
            return null;
        }

        OrderResponseDto orderResponseDto = new OrderResponseDto();

        orderResponseDto.setId( order.getId() );
        orderResponseDto.setTotal( order.getTotal() );
        orderResponseDto.setLemonades( lemonadeMapper.entitiesToResponseDtos( order.getLemonades() ) );
        orderResponseDto.setCustomer( customerMapper.entityToResponseDto( order.getCustomer() ) );
        orderResponseDto.setLemonadeStand( lemonadeStandMapper.entityToResponseDto( order.getLemonadeStand() ) );

        return orderResponseDto;
    }

    @Override
    public List<OrderResponseDto> entitiesToResponseDtos(List<Order> orders) {
        if ( orders == null ) {
            return null;
        }

        List<OrderResponseDto> list = new ArrayList<OrderResponseDto>( orders.size() );
        for ( Order order : orders ) {
            list.add( entityToResponseDto( order ) );
        }

        return list;
    }

    protected List<Lemonade> lemonadeDtoListToLemonadeList(List<LemonadeDto> list) {
        if ( list == null ) {
            return null;
        }

        List<Lemonade> list1 = new ArrayList<Lemonade>( list.size() );
        for ( LemonadeDto lemonadeDto : list ) {
            list1.add( lemonadeMapper.lemonadeDtoToEntity( lemonadeDto ) );
        }

        return list1;
    }
}
