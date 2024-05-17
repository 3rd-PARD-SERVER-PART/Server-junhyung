package org.example.pard.member.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.pard.member.entity.Member;


// get request를 받았을때 처리해줄 MemberDTO
// Receives Member Entity and converts it into DTO 

/*
The primary goal of DTOs is to reduce the number of method calls between these layers
 by aggregating data into a single object. 
 In a Spring Boot application, DTOs are commonly used to encapsulate data transferred
  between the controller and service layers, or between the service layer and the persistence layer
*/

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MemberReadDTO {
    private Long id;
    private String name;
    private String part;
    private int age;

    public MemberReadDTO toDTO(Member member) {
        return MemberReadDTO.builder()
                .id(member.getId())
                .age(member.getAge())
                .name(member.getName())
                .part(member.getPart())
                .build();
    }
}


