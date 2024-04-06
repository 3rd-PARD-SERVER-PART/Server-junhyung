package com.pard.secondhomework.user.service;

import com.pard.secondhomework.user.dto.HobbyDto;
import com.pard.secondhomework.user.repository.HobbyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HobbyService {
    private final HobbyRepository hobbyRepository;
    public void saveHobby(HobbyDto hobbyDto){
        hobbyRepository.saveHobby(hobbyDto);
    }

    public HobbyDto findById(Integer hobbyId){
        return hobbyRepository.findById(hobbyId);
    }

    public List<HobbyDto> findAll(){
        return hobbyRepository.findAll();
    }

    public void update(Integer hobbyId, HobbyDto hobbyDto){
        hobbyRepository.update(hobbyId, hobbyDto);
    }

    public void delete(Integer hobbyId){
        hobbyRepository.delete(hobbyId);
    }
}
