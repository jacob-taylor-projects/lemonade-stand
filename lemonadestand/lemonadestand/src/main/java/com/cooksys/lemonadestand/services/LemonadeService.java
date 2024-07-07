package com.cooksys.lemonadestand.services;

import com.cooksys.lemonadestand.entities.Lemonade;
import com.cooksys.lemonadestand.model.LemonadeRequestDto;
import com.cooksys.lemonadestand.model.LemonadeResponseDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface LemonadeService {
    List<LemonadeResponseDto> getAllLemonades();

    LemonadeResponseDto createLemonade(LemonadeRequestDto lemonadeRequestDto);

    Lemonade getLemonade(Long id);

    LemonadeResponseDto getLemonadeById(Long id);

    LemonadeResponseDto updateLemonade(Long id, LemonadeRequestDto lemonadeRequestDto);

    LemonadeResponseDto deleteLemonade(Long id);
}
