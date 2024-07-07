package com.cooksys.lemonadestand.services.impl;

import com.cooksys.lemonadestand.entities.Customer;
import com.cooksys.lemonadestand.entities.Lemonade;
import com.cooksys.lemonadestand.entities.Order;
import com.cooksys.lemonadestand.exceptions.NotFoundException;
import com.cooksys.lemonadestand.mappers.OrderMapper;
import com.cooksys.lemonadestand.model.OrderRequestDto;
import com.cooksys.lemonadestand.model.OrderResponseDto;
import com.cooksys.lemonadestand.repos.OrderRepo;
import com.cooksys.lemonadestand.services.CustomerService;
import com.cooksys.lemonadestand.services.LemonadeService;
import com.cooksys.lemonadestand.services.LemonadeStandService;
import com.cooksys.lemonadestand.services.OrderService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderMapper orderMapper;

    private final OrderRepo orderRepo;

    private final LemonadeService lemonadeService;

    private final CustomerService customerService;

    private final LemonadeStandService lemonadeStandService;

    private void setupOrder(Order order){
        double total=0.0;
        List<Lemonade> lemonades=new ArrayList<>();
        for (Lemonade lemonade:order.getLemonades()){
            lemonade=lemonadeService.getLemonade(lemonade.getId());
            lemonades.add(lemonade);
            total+=lemonade.getPrice();
        }
        order.setTotal(total);
        order.setLemonades(lemonades);
        order.setCustomer(customerService.getCustomer(order.getCustomer().getId()));
        order.setLemonadeStand(lemonadeStandService.getLemonadeStand(order.getLemonadeStand().getId()));
    }

    @Override
    public Order getOrder(Long id){
        Optional<Order> order=orderRepo.findById(id);
        if (order.isEmpty()){
            throw new NotFoundException("Could not find order by that id:"+id);
        }
        return order.get();
    }

    @Override
    public OrderResponseDto createOrder(OrderRequestDto orderRequestDto) {
        Order order=orderMapper.requestDtoToEntity(orderRequestDto);
            setupOrder(order);
        return orderMapper.entityToResponseDto(orderRepo.saveAndFlush(order));
    }

    @Override
    public List<OrderResponseDto> getAllOrders() {
        return orderMapper.entitiesToResponseDtos(orderRepo.findAll());
    }

    @Override
    public OrderResponseDto getOrderById(Long id) {
        return orderMapper.entityToResponseDto(getOrder(id));
    }
    //need to implement
    @Override
    public OrderResponseDto updateOrder(Long id, OrderRequestDto orderRequestDto) {
        Order orderToUpdate=getOrder(id);
        Order updateInfo=orderMapper.requestDtoToEntity(orderRequestDto);
        double total=0.0;
        List<Lemonade> lemonades=new ArrayList<>();
        for (Lemonade lemonade:updateInfo.getLemonades()){
            lemonade=lemonadeService.getLemonade(lemonade.getId());
            lemonades.add(lemonade);
            total+=lemonade.getPrice();
        }
        orderToUpdate.setTotal(total);
        orderToUpdate.setLemonades(lemonades);
        orderToUpdate.setCustomer(customerService.getCustomer(updateInfo.getCustomer().getId()));
        orderToUpdate.setLemonadeStand(lemonadeStandService.getLemonadeStand(updateInfo.getLemonadeStand().getId()));
        return orderMapper.entityToResponseDto(orderRepo.saveAndFlush(orderToUpdate));
    }

    @Override
    public OrderResponseDto deleteOrder(Long id) {
        Order orderToDelete=getOrder(id);
        orderRepo.delete(orderToDelete);
        return orderMapper.entityToResponseDto(orderToDelete);
    }
}
