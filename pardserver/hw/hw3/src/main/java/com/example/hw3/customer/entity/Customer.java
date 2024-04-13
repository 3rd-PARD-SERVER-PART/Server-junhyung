package com.example.hw3.customer.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long customerId;
    @Column(name = "name", length = 20) //db column 이름을 email 이고 최대 가능 length 가 20
    private String customerName; // user_email 이렇게 원래는 이렇게 들어감. 하지만 위에서 @Column으로 email 로 세팅해줘서 그냥 컬럼 값이 email로 들어감.
    @Column(name = "burgerOrder")
    private String customerOrder;

    @Column(name = "jinsang")
    private String customerJinsang;

    @Column(name = "vip")
    private String customerVIP;
    @CreationTimestamp
    private Timestamp userSignupTime;

}
