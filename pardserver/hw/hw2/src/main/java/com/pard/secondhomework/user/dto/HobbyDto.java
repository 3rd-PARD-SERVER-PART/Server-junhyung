package com.pard.secondhomework.user.dto;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HobbyDto {
    private Integer hobbyId;
    private String hobbyName;
    private Integer difficulty;

    private Integer price;
}
