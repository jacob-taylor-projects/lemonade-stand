package com.cooksys.lemonadestand;

import com.cooksys.lemonadestand.entities.Customer;
import com.cooksys.lemonadestand.entities.Lemonade;
import com.cooksys.lemonadestand.entities.LemonadeStand;
import com.cooksys.lemonadestand.entities.Order;
import com.cooksys.lemonadestand.repos.CustomerRepo;
import com.cooksys.lemonadestand.repos.LemonadeRepo;
import com.cooksys.lemonadestand.repos.LemonadeStandRepo;
import com.cooksys.lemonadestand.repos.OrderRepo;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class Seeder implements CommandLineRunner {

    private LemonadeRepo lemonadeRepo;
    private OrderRepo orderRepo;
    private CustomerRepo customerRepo;
    private LemonadeStandRepo lemonadeStandRepo;

    @Override
    public void run(String... args) throws Exception {
        Lemonade lemonade=new Lemonade();
        lemonade.setLemonJuice(3.25);
        lemonade.setWater(2.5);
        lemonade.setSugar(1.25);
        lemonade.setIceCubes(5);
        lemonade.setPrice(4.5);



        lemonadeRepo.saveAndFlush(lemonade);


        System.out.println(lemonadeRepo.findAll());

    }
}
