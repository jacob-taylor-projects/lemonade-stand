package com.cooksys.lemonadestand.controllers;

import com.cooksys.lemonadestand.model.CustomerRequestDto;
import com.cooksys.lemonadestand.model.CustomerResponseDto;
import com.cooksys.lemonadestand.model.OrderRequestDto;
import com.cooksys.lemonadestand.model.OrderResponseDto;
import com.cooksys.lemonadestand.services.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("orders")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public OrderResponseDto createOrder(@RequestBody OrderRequestDto orderRequestDto){
        return orderService.createOrder(orderRequestDto);
    }
    @GetMapping
    public List<OrderResponseDto> getAllOrders(){
        return orderService.getAllOrders();
    }

    @GetMapping("/{id}")
    public OrderResponseDto getOrderById(@PathVariable Long id){
        return orderService.getOrderById(id);
    }

    @PatchMapping("/{id}")
    public OrderResponseDto updateOrder(@PathVariable Long id,@RequestBody OrderRequestDto orderRequestDto){
        return orderService.updateOrder(id,orderRequestDto);
    }

    @DeleteMapping("/{id}")
    public OrderResponseDto deleteOrder(@PathVariable Long id){
        return orderService.deleteOrder(id);
    }
}
