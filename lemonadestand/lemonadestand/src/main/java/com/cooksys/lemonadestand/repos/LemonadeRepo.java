package com.cooksys.lemonadestand.repos;

import com.cooksys.lemonadestand.entities.Lemonade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LemonadeRepo extends JpaRepository<Lemonade,Long> {
    Optional<Lemonade> findById(Long id);
}
