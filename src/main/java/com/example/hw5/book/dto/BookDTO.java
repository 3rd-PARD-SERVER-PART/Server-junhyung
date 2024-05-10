package com.example.hw5.book.dto;


import com.example.hw5.book.entity.Book;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

public class BookDTO {
    @Getter
    @Setter
    public static class Create{
        private String name;
    }

    @Getter
    @Setter
    @Builder
    public static class Loan{
        private Long bookId;
        private String name;
        private boolean isLoan;
    }

    @Getter
    @Setter
    public static class Read{
        private Long bookId;
        private String name;
        private boolean isLoan;

        public Read(Book book){
            this.bookId = book.getBookId();
            this.name = book.getName();
            this.isLoan = book.isLoan();
        }
    }
}
