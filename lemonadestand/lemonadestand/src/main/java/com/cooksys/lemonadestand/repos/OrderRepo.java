package com.cooksys.lemonadestand.repos;

import com.cooksys.lemonadestand.entities.Customer;
import com.cooksys.lemonadestand.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OrderRepo extends JpaRepository<Order,Long> {
    Optional<Order> findById(Long id);
}
