package com.example.hw4.user.service;

import com.example.hw4.book.entity.Book;
import com.example.hw4.book.repo.BookRepo;
import com.example.hw4.user.dto.UserDTO;
import com.example.hw4.user.entity.User;
import com.example.hw4.user.entity.UserLoanHistory;
import com.example.hw4.user.repo.UserLoanHistoryRepo;
import com.example.hw4.user.repo.UserRepo;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;
@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepo userRepo;
    private final BookRepo bookRepo;
    private final UserLoanHistoryRepo userLoanHistory;

    public void createUser(UserDTO.Create dto) {
        userRepo.save(User.toEntity(dto));
    }

    @Transactional
    public String borrow(UserDTO.Loan dto) {
        Book book = bookRepo.findById(dto.getBookId()).orElseThrow();
        if (!book.isLoan()) {
            userLoanHistory.save(UserLoanHistory.toEntity(
                    userRepo.findById(dto.getUserId()).orElseThrow()
                    , bookRepo.findById(dto.getBookId()).orElseThrow()));
            book.isReturn();
            return "책 빌림";
        }
        return "책을 빌릴 수 없음";
    }

    public List<UserDTO.Read> readAll() {
        return userRepo.findAll().stream()
                .map(user -> UserDTO.Read.toDTO(user
                        ,user.getUserLoanHistories()
                                .stream()
                                .map(UserDTO.LoanRead::toDTO).
                                collect(Collectors.toList())

                ))
                .collect(Collectors.toList());
    }

    public UserDTO.Read readById(Long userId) {
        User user = userRepo.findById(userId).orElseThrow();
        return UserDTO.Read.toDTO(user,user.getUserLoanHistories().stream().map(UserDTO.LoanRead::toDTO).collect(Collectors.toList()));
    }
    @Transactional
    public String returnBook(UserDTO.Loan dto) {
        Book book = bookRepo.findById(dto.getBookId()).orElseThrow();
        User user = userRepo.findById(dto.getUserId()).orElseThrow();
        UserLoanHistory userLoanHistory2 = userLoanHistory.findByUserAndBookAndIsReturn(user, book, false);
        if (!userLoanHistory2.isReturn()) {
            userLoanHistory2.isLoan();
            book.isReturn();
            return "책을 반납함";
        }
        return "이미 반납된 책입니다";
    }



}

