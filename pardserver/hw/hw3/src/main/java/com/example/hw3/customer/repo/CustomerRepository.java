package com.example.hw3.customer.repo;

import com.example.hw3.customer.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,Long> {
    public Customer findByCustomerOrder(String customerOrder);
    public Customer findByCustomerJinsang(String customerName);
    public Customer findByCustomerVIP(String customerName);

}
