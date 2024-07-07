package com.cooksys.lemonadestand.mappers;

import com.cooksys.lemonadestand.entities.Order;
import com.cooksys.lemonadestand.model.OrderRequestDto;
import com.cooksys.lemonadestand.model.OrderResponseDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring",uses = {CustomerMapper.class, LemonadeStandMapper.class, LemonadeMapper.class})
public interface OrderMapper {
    Order requestDtoToEntity(OrderRequestDto orderRequestDto);

    OrderResponseDto entityToResponseDto(Order order);

    List<OrderResponseDto> entitiesToResponseDtos(List<Order> orders);
}
