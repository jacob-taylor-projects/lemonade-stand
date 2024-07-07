package com.cooksys.lemonadestand.controllers;

import com.cooksys.lemonadestand.model.CustomerRequestDto;
import com.cooksys.lemonadestand.model.CustomerResponseDto;
import com.cooksys.lemonadestand.model.LemonadeStandRequestDto;
import com.cooksys.lemonadestand.model.LemonadeStandResponseDto;
import com.cooksys.lemonadestand.services.CustomerService;
import com.cooksys.lemonadestand.services.LemonadeStandService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("lemonadestands")
@RequiredArgsConstructor
public class LemonadeStandController {
    private final LemonadeStandService lemonadeStandService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public LemonadeStandResponseDto createLemonadeStand(@RequestBody LemonadeStandRequestDto lemonadeStandRequestDto){
        return lemonadeStandService.createLemonadeStand(lemonadeStandRequestDto);
    }

    @GetMapping
    public List<LemonadeStandResponseDto> getAllLemonadeStands(){
        return lemonadeStandService.getAllLemonadeStands();
    }

    @GetMapping("/{id}")
    public LemonadeStandResponseDto getLemonadeStandById(@PathVariable Long id){
        return lemonadeStandService.getLemonadeStandById(id);
    }

    @PutMapping("/{id}")
    public LemonadeStandResponseDto updateLemonadeStand(@PathVariable Long id,@RequestBody LemonadeStandRequestDto lemonadeStandRequestDto){
        return lemonadeStandService.updateLemonadeStand(id,lemonadeStandRequestDto);
    }

    @DeleteMapping("/{id}")
    public LemonadeStandResponseDto deleteLemonadeStand(@PathVariable Long id){
        return lemonadeStandService.deleteLemonadeStand(id);
    }
}
