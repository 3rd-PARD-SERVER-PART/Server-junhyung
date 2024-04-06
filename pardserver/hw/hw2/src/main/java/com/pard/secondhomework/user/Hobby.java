package com.pard.secondhomework.user;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Hobby {
    private Integer hobbyId;
    private Integer difficulty;
    private String hobbyName;
    private Integer price;

}
