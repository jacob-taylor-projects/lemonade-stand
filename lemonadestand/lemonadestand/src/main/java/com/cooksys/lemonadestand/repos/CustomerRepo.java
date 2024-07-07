package com.cooksys.lemonadestand.repos;

import com.cooksys.lemonadestand.entities.Customer;
import com.cooksys.lemonadestand.entities.Lemonade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepo extends JpaRepository<Customer,Long> {
    Optional<Customer> findById(Long id);
}
