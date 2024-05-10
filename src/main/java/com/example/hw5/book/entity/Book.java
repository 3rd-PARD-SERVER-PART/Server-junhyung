package com.example.hw5.book.entity;

import com.example.hw5.book.dto.BookDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookId;

    private String name;

    @ColumnDefault("0")
    private boolean isLoan;

    public static Book toEntity(BookDTO.Create dto) {
        return Book.builder()
                .name(dto.getName())
                .build();
    }

    public void isReturn() {
        this.isLoan = !this.isLoan;
    }
}
