package org.example.pard.member.dto;

import lombok.Getter;


// 멤버 DTO (repo 를 제외한 모든 부분 (비즈니스 로직 등등) 을 처리할때 DTO 형태로 처리됨))
// create 를 위해 만들어둔 DTO
@Getter
public class MemberCreateDTO {

    private String name;
    private String part;
    private int age;

}
