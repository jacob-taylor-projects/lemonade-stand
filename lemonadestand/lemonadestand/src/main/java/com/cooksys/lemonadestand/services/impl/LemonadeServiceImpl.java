package com.cooksys.lemonadestand.services.impl;

import com.cooksys.lemonadestand.entities.Lemonade;
import com.cooksys.lemonadestand.exceptions.BadRequestException;
import com.cooksys.lemonadestand.exceptions.NotFoundException;
import com.cooksys.lemonadestand.mappers.LemonadeMapper;
import com.cooksys.lemonadestand.model.LemonadeRequestDto;
import com.cooksys.lemonadestand.model.LemonadeResponseDto;
import com.cooksys.lemonadestand.repos.LemonadeRepo;
import com.cooksys.lemonadestand.services.LemonadeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class LemonadeServiceImpl implements LemonadeService {
    private LemonadeRepo lemonadeRepo;
    private LemonadeMapper lemonadeMapper;

    @Override
    public List<LemonadeResponseDto> getAllLemonades() {
        return lemonadeMapper.entitiesToResponseDtos(lemonadeRepo.findAll());
    }

    private void setLemonadePrice(Lemonade lemonade){
        lemonade.setPrice(lemonade.getLemonJuice()*.2+ lemonade.getWater()*.01+ lemonade.getSugar()*.15+ lemonade.getIceCubes()*.05+.5);

    }

    private void validateLemonadeRequest(LemonadeRequestDto lemonadeRequestDto){
        if(lemonadeRequestDto.getLemonJuice()==null||lemonadeRequestDto.getWater()==null||lemonadeRequestDto.getSugar()==null||lemonadeRequestDto.getIceCubes()==null){
            throw new BadRequestException("All fields are required for creating a lemonade");
        }
    }
    @Override
    public Lemonade getLemonade(Long id){
        Optional<Lemonade> lemonade=lemonadeRepo.findById(id);
        if (lemonade.isEmpty()){
            throw new NotFoundException("Could not find lemonade by that id:"+id);
        }
        return lemonade.get();
    }

    @Override
    public LemonadeResponseDto createLemonade(LemonadeRequestDto lemonadeRequestDto) {
        validateLemonadeRequest(lemonadeRequestDto);
        Lemonade lemonadeToSave=lemonadeMapper.requestDtoToEntity(lemonadeRequestDto);
        setLemonadePrice(lemonadeToSave);
      return lemonadeMapper.entityToResponseDto(lemonadeRepo.saveAndFlush(lemonadeToSave));
    }

    @Override
    public LemonadeResponseDto getLemonadeById(Long id) {

        return lemonadeMapper.entityToResponseDto(getLemonade(id));
    }

    @Override
    public LemonadeResponseDto updateLemonade(Long id, LemonadeRequestDto lemonadeRequestDto) {
        validateLemonadeRequest(lemonadeRequestDto);

        Lemonade lemonadeToUpdate=getLemonade(id);
        lemonadeToUpdate.setLemonJuice(lemonadeRequestDto.getLemonJuice());
        lemonadeToUpdate.setWater(lemonadeRequestDto.getWater());
        lemonadeToUpdate.setSugar(lemonadeRequestDto.getSugar());
        lemonadeToUpdate.setIceCubes(lemonadeRequestDto.getIceCubes());
        setLemonadePrice(lemonadeToUpdate);
        return lemonadeMapper.entityToResponseDto(lemonadeRepo.saveAndFlush(lemonadeToUpdate));
    }

    @Override
    public LemonadeResponseDto deleteLemonade(Long id) {
        Lemonade lemonadeToDelete=getLemonade(id);
        lemonadeRepo.delete(lemonadeToDelete);
        return lemonadeMapper.entityToResponseDto(lemonadeToDelete);
    }
}
