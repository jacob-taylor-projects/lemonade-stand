package com.cooksys.lemonadestand.services.impl;

import com.cooksys.lemonadestand.entities.Customer;
import com.cooksys.lemonadestand.entities.LemonadeStand;
import com.cooksys.lemonadestand.exceptions.BadRequestException;
import com.cooksys.lemonadestand.exceptions.NotFoundException;
import com.cooksys.lemonadestand.mappers.LemonadeStandMapper;
import com.cooksys.lemonadestand.model.CustomerRequestDto;
import com.cooksys.lemonadestand.model.LemonadeStandRequestDto;
import com.cooksys.lemonadestand.model.LemonadeStandResponseDto;
import com.cooksys.lemonadestand.repos.LemonadeStandRepo;
import com.cooksys.lemonadestand.services.LemonadeStandService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class LemonadeStandServiceImpl implements LemonadeStandService {
    private final LemonadeStandRepo lemonadeStandRepo;
    private final LemonadeStandMapper lemonadeStandMapper;

    private void validateLemonadeStandRequest(LemonadeStandRequestDto lemonadeStandRequestDto){
        if(lemonadeStandRequestDto.getName()==null){
            throw new BadRequestException("A name is required for creating a lemonade stand");
        }
    }
    @Override
    public LemonadeStand getLemonadeStand(Long id){
        Optional<LemonadeStand> lemonadeStand=lemonadeStandRepo.findById(id);
        if (lemonadeStand.isEmpty()){
            throw new NotFoundException("Could not find lemonade stand by that id:"+id);
        }
        return lemonadeStand.get();
    }

    @Override
    public LemonadeStandResponseDto createLemonadeStand(LemonadeStandRequestDto lemonadeStandRequestDto) {
        validateLemonadeStandRequest(lemonadeStandRequestDto);
        return lemonadeStandMapper.entityToResponseDto(lemonadeStandRepo.saveAndFlush(lemonadeStandMapper.requestDtoToEntity(lemonadeStandRequestDto)));
    }

    @Override
    public List<LemonadeStandResponseDto> getAllLemonadeStands() {
        return lemonadeStandMapper.entitiesToResponseDtos(lemonadeStandRepo.findAll());
    }

    @Override
    public LemonadeStandResponseDto getLemonadeStandById(Long id) {
       return lemonadeStandMapper.entityToResponseDto(getLemonadeStand(id));
    }

    @Override
    public LemonadeStandResponseDto updateLemonadeStand(Long id, LemonadeStandRequestDto lemonadeStandRequestDto) {
        LemonadeStand lemonadeStandToUpdate=getLemonadeStand(id);
        validateLemonadeStandRequest(lemonadeStandRequestDto);
        lemonadeStandToUpdate.setName(lemonadeStandRequestDto.getName());
        return lemonadeStandMapper.entityToResponseDto(lemonadeStandToUpdate);
    }

    @Override
    public LemonadeStandResponseDto deleteLemonadeStand(Long id) {
        LemonadeStand lemonadeStandToDelete=getLemonadeStand(id);
        lemonadeStandRepo.delete(lemonadeStandToDelete);
        return lemonadeStandMapper.entityToResponseDto(lemonadeStandToDelete);
    }
}
