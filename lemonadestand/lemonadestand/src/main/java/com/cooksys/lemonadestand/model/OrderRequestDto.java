package com.cooksys.lemonadestand.model;

import com.cooksys.lemonadestand.entities.LemonadeStand;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Data
public class OrderRequestDto {
    List<LemonadeDto> lemonades;

    CustomerDto customer;

    LemonadeStandDto lemonadeStand;
}
