package com.example.hw3.customer.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomerDto {
    private String name;
    private String burgerOrder;
    private String jinsang;
    private String vip;
}
