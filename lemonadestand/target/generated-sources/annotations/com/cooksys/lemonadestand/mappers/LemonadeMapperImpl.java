package com.cooksys.lemonadestand.mappers;

import com.cooksys.lemonadestand.entities.Lemonade;
import com.cooksys.lemonadestand.model.LemonadeDto;
import com.cooksys.lemonadestand.model.LemonadeRequestDto;
import com.cooksys.lemonadestand.model.LemonadeResponseDto;
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
public class LemonadeMapperImpl implements LemonadeMapper {

    @Override
    public Lemonade requestDtoToEntity(LemonadeRequestDto lemonadeRequestDto) {
        if ( lemonadeRequestDto == null ) {
            return null;
        }

        Lemonade lemonade = new Lemonade();

        if ( lemonadeRequestDto.getLemonJuice() != null ) {
            lemonade.setLemonJuice( lemonadeRequestDto.getLemonJuice() );
        }
        if ( lemonadeRequestDto.getWater() != null ) {
            lemonade.setWater( lemonadeRequestDto.getWater() );
        }
        if ( lemonadeRequestDto.getSugar() != null ) {
            lemonade.setSugar( lemonadeRequestDto.getSugar() );
        }
        if ( lemonadeRequestDto.getIceCubes() != null ) {
            lemonade.setIceCubes( lemonadeRequestDto.getIceCubes() );
        }

        return lemonade;
    }

    @Override
    public Lemonade lemonadeDtoToEntity(LemonadeDto lemonadeDto) {
        if ( lemonadeDto == null ) {
            return null;
        }

        Lemonade lemonade = new Lemonade();

        lemonade.setId( lemonadeDto.getId() );

        return lemonade;
    }

    @Override
    public LemonadeResponseDto entityToResponseDto(Lemonade lemonade) {
        if ( lemonade == null ) {
            return null;
        }

        LemonadeResponseDto lemonadeResponseDto = new LemonadeResponseDto();

        lemonadeResponseDto.setId( lemonade.getId() );
        lemonadeResponseDto.setLemonJuice( lemonade.getLemonJuice() );
        lemonadeResponseDto.setWater( lemonade.getWater() );
        lemonadeResponseDto.setSugar( lemonade.getSugar() );
        lemonadeResponseDto.setIceCubes( lemonade.getIceCubes() );
        lemonadeResponseDto.setPrice( lemonade.getPrice() );

        return lemonadeResponseDto;
    }

    @Override
    public List<LemonadeResponseDto> entitiesToResponseDtos(List<Lemonade> lemonades) {
        if ( lemonades == null ) {
            return null;
        }

        List<LemonadeResponseDto> list = new ArrayList<LemonadeResponseDto>( lemonades.size() );
        for ( Lemonade lemonade : lemonades ) {
            list.add( entityToResponseDto( lemonade ) );
        }

        return list;
    }
}
