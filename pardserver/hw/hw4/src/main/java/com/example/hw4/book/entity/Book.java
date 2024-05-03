package com.example.hw4.book.entity;

import jakarta.persistence.*;
import lombok.*;
import com.example.hw4.book.dto.BookDTO;
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
