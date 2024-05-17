package org.example.pard.member.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
import org.example.pard.member.dto.MemberCreateDTO;


// DB에 저장될 형태인 Entity. DTO 형태로 가공이 되었다면 Entity 형태로변환되어 DB에 저장되어야한다.
//    JPA automatically creates and assigns Member Entity's PK value 
@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Member {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id; // member id

    private String name; // member name
 
    private String part; // member part 

    private int age; // member age 

    //convert MemberCreateDTO -> Member Entity 
    //used for converting DTO received from the client to Entity
    public Member toEntity(MemberCreateDTO dto) {
        return Member.builder()
                .age(dto.getAge())
                .part(dto.getPart())
                .name(dto.getName())
                .build();
    }
}
