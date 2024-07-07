package com.cooksys.lemonadestand.repos;

import com.cooksys.lemonadestand.entities.Customer;
import com.cooksys.lemonadestand.entities.LemonadeStand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LemonadeStandRepo extends JpaRepository<LemonadeStand,Long> {
    Optional<LemonadeStand> findById(Long id);
}
