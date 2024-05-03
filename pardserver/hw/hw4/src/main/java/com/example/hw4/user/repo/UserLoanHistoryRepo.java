package com.example.hw4.user.repo;

import com.example.hw4.book.entity.Book;
import com.example.hw4.user.entity.User;
import com.example.hw4.user.entity.UserLoanHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserLoanHistoryRepo extends JpaRepository<UserLoanHistory, Long> {
    UserLoanHistory findByUserAndBookAndIsReturn(User user, Book book, boolean isReturn);
}
