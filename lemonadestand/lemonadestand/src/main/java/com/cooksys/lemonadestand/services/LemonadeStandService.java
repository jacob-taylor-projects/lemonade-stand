package com.cooksys.lemonadestand.services;

import com.cooksys.lemonadestand.entities.LemonadeStand;
import com.cooksys.lemonadestand.model.LemonadeStandRequestDto;
import com.cooksys.lemonadestand.model.LemonadeStandResponseDto;

import java.util.List;

public interface LemonadeStandService {
    LemonadeStand getLemonadeStand(Long id);

    LemonadeStandResponseDto createLemonadeStand(LemonadeStandRequestDto lemonadeStandRequestDto);

    List<LemonadeStandResponseDto> getAllLemonadeStands();

    LemonadeStandResponseDto getLemonadeStandById(Long id);

    LemonadeStandResponseDto updateLemonadeStand(Long id, LemonadeStandRequestDto lemonadeStandRequestDto);

    LemonadeStandResponseDto deleteLemonadeStand(Long id);
}
