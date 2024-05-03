package com.example.hw4.user.entity;

import com.example.hw4.book.entity.Book;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import org.hibernate.annotations.ColumnDefault;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserLoanHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn(nullable = false, name = "user_id")
    @ManyToOne
    private User user;

    @ManyToOne
    @JoinColumn(nullable = false ,name = "book_id")
    private Book book;

    @ColumnDefault("0")
    private boolean isReturn;

    public static UserLoanHistory toEntity(User user, Book book) {
        return UserLoanHistory.builder()
                .user(user)
                .book(book)
                .build();
    }
    public void isLoan() {
        this.isReturn = !this.isReturn;
    }
}
