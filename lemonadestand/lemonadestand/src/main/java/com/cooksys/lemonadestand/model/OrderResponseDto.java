package com.cooksys.lemonadestand.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Data
public class OrderResponseDto {
    private Long id;

    private double total;

    private List<LemonadeResponseDto> lemonades;

    private CustomerResponseDto customer;

    private LemonadeStandResponseDto lemonadeStand;
}
