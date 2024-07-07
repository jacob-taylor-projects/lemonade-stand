package com.cooksys.lemonadestand.services;

import com.cooksys.lemonadestand.entities.Order;
import com.cooksys.lemonadestand.model.OrderRequestDto;
import com.cooksys.lemonadestand.model.OrderResponseDto;

import java.util.List;

public interface OrderService {
    OrderResponseDto createOrder(OrderRequestDto orderRequestDto);

    List<OrderResponseDto> getAllOrders();

    OrderResponseDto getOrderById(Long id);

    OrderResponseDto updateOrder(Long id, OrderRequestDto orderRequestDto);

    OrderResponseDto deleteOrder(Long id);

    Order getOrder(Long id);
}
