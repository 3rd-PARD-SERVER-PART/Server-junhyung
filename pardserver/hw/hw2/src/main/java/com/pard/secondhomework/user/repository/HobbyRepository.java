package com.pard.secondhomework.user.repository;

import com.pard.secondhomework.user.Hobby;
import com.pard.secondhomework.user.dto.HobbyDto;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository // 이 파일이 저장소 역할을 해 줄 것이다라고 말해주는 것.
public class HobbyRepository {
    private static final Map<Integer, Hobby> myHobby = new HashMap<>();

    //Create
    public void saveHobby(HobbyDto hobbyDto){


        if(hobbyDto.getHobbyId()==null){
            if(myHobby.isEmpty()) hobbyDto.setHobbyId(1);
            else {
                hobbyDto.setHobbyId(Collections.max(myHobby.keySet()) + 1);
            }
        }


        if(myHobby.containsKey(hobbyDto.getHobbyId())){
            System.out.println("Save rejected. Id exists.");
            return;
        }

        Hobby h = Hobby.builder()
                .hobbyName(hobbyDto.getHobbyName())
                .hobbyId(hobbyDto.getHobbyId())
                .difficulty(hobbyDto.getDifficulty())
                .price(hobbyDto.getPrice())
                .build();
        myHobby.put(hobbyDto.getHobbyId(), h);
    }


    //Database 가 털리지 않기 위해 Dto 로 보내는 이유도 있다
    //Read
    public HobbyDto findById(Integer hobbyId){
        Hobby hobby = myHobby.get(hobbyId);
        return HobbyDto.builder()
                .hobbyId(hobby.getHobbyId())
                .hobbyName(hobby.getHobbyName())
                .difficulty(hobby.getDifficulty())
                .price(hobby.getDifficulty())
                .build();
    }

    // 롱커톤 때 디비를 털 수도 있다. 잘 막아놔야 함.

    public List<HobbyDto> findAll(){
        return myHobby.values().stream()
                .map(hobby -> HobbyDto.builder()
                    .hobbyId(hobby.getHobbyId())
                    .hobbyName(hobby.getHobbyName())
                        .difficulty(hobby.getDifficulty())
                        .price(hobby.getPrice())
                        .build()).toList();
    }

    //Update
    public void update(Integer hobbyId, HobbyDto hobbyDto){
        Hobby hobby = myHobby.get(hobbyId);
        if(hobbyDto.getHobbyId()!=null) hobby.setHobbyId(hobbyDto.getHobbyId());
        hobby.setHobbyId(hobbyDto.getHobbyId());
        hobby.setHobbyName(hobby.getHobbyName());
        hobby.setDifficulty(hobby.getDifficulty());
        hobby.setPrice(hobby.getPrice());
    }

    //Delete
    public void delete(Integer hobbyId){
        myHobby.remove(hobbyId);
    }
}
