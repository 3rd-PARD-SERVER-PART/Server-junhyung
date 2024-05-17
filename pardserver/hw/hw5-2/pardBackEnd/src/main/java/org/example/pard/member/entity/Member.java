package org.example.pard.member.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
import org.example.pard.member.dto.MemberCreateDTO;


// DB에 저장될 형태인 Entity. DTO 형태로 가공이 되었다면 Entity 형태로변환되어 DB에 저장되어야한다.
@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Member {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    private String name;

    private String part;

    private int age;

    public Member toEntity(MemberCreateDTO dto) {
        return Member.builder()
                .age(dto.getAge())
                .part(dto.getPart())
                .name(dto.getName())
                .build();
    }
}
