package com.cooksys.lemonadestand.mappers;

import com.cooksys.lemonadestand.entities.LemonadeStand;
import com.cooksys.lemonadestand.model.LemonadeStandDto;
import com.cooksys.lemonadestand.model.LemonadeStandRequestDto;
import com.cooksys.lemonadestand.model.LemonadeStandResponseDto;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-06-17T17:16:51-0500",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 22.0.1 (Oracle Corporation)"
)
@Component
public class LemonadeStandMapperImpl implements LemonadeStandMapper {

    @Override
    public LemonadeStandResponseDto entityToResponseDto(LemonadeStand lemonadeStand) {
        if ( lemonadeStand == null ) {
            return null;
        }

        LemonadeStandResponseDto lemonadeStandResponseDto = new LemonadeStandResponseDto();

        lemonadeStandResponseDto.setId( lemonadeStand.getId() );
        lemonadeStandResponseDto.setName( lemonadeStand.getName() );

        return lemonadeStandResponseDto;
    }

    @Override
    public LemonadeStand lemonadeStandDtoToEntity(LemonadeStandDto lemonadeStandDto) {
        if ( lemonadeStandDto == null ) {
            return null;
        }

        LemonadeStand lemonadeStand = new LemonadeStand();

        lemonadeStand.setId( lemonadeStandDto.getId() );

        return lemonadeStand;
    }

    @Override
    public LemonadeStand requestDtoToEntity(LemonadeStandRequestDto lemonadeStandRequestDto) {
        if ( lemonadeStandRequestDto == null ) {
            return null;
        }

        LemonadeStand lemonadeStand = new LemonadeStand();

        lemonadeStand.setName( lemonadeStandRequestDto.getName() );

        return lemonadeStand;
    }

    @Override
    public List<LemonadeStandResponseDto> entitiesToResponseDtos(List<LemonadeStand> lemonadeStand) {
        if ( lemonadeStand == null ) {
            return null;
        }

        List<LemonadeStandResponseDto> list = new ArrayList<LemonadeStandResponseDto>( lemonadeStand.size() );
        for ( LemonadeStand lemonadeStand1 : lemonadeStand ) {
            list.add( entityToResponseDto( lemonadeStand1 ) );
        }

        return list;
    }
}
