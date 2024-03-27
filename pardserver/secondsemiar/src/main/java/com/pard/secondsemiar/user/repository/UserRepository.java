package com.pard.secondsemiar.user.repository;

import com.pard.secondsemiar.user.User;
import com.pard.secondsemiar.user.dto.UserDto;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository // 이 파일이 저장소 역할을 해 줄 것이다라고 말해주는 것.
public class UserRepository {
    private static final Map<Integer, User> handong = new HashMap<>();

    //Create
    public void save(UserDto userDto){
        User u = User.builder()
                .studentName(userDto.getStudentName())
                .studentId(userDto.getStudentId())
                .build();
        handong.put(userDto.getStudentId(), u);
    }


    //Database 가 털리지 않기 위해 Dto 로 보내는 이유도 있다
    //Read
    public UserDto findById(Integer studentId){
        User user = handong.get(studentId);
        return UserDto.builder()
                .studentId(user.getStudentId())
                .studentName(user.getStudentName())
                .build();
    }

    // 롱커톤 때 디비를 털 수도 있다. 잘 막아놔야 함.

    public List<UserDto> findAll(){
        return handong.values().stream()
                .map(user->UserDto.builder()
                    .studentId(user.getStudentId())
                    .studentName(user.getStudentName())
                        .build()).toList();
    }

    //Update
    public void update(Integer studentId, UserDto userDto){
        User user = handong.get(studentId);
        user.setStudentId(userDto.getStudentId());
        user.setStudentName(user.getStudentName());
//        handong.put(user.getStudentId(), user); //put 부분하면 1개가 더 생긴다고 함.
    }

    //Delete
    public void delete(Integer studentId){
        handong.remove(studentId);
    }
}
