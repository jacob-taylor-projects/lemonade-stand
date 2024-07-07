package com.cooksys.lemonadestand.mappers;

import com.cooksys.lemonadestand.entities.LemonadeStand;
import com.cooksys.lemonadestand.model.LemonadeResponseDto;
import com.cooksys.lemonadestand.model.LemonadeStandDto;
import com.cooksys.lemonadestand.model.LemonadeStandRequestDto;
import com.cooksys.lemonadestand.model.LemonadeStandResponseDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface LemonadeStandMapper {
    LemonadeStandResponseDto entityToResponseDto(LemonadeStand lemonadeStand);

    LemonadeStand lemonadeStandDtoToEntity(LemonadeStandDto lemonadeStandDto);

    LemonadeStand requestDtoToEntity(LemonadeStandRequestDto lemonadeStandRequestDto);

    List<LemonadeStandResponseDto> entitiesToResponseDtos(List<LemonadeStand> lemonadeStand);
}
