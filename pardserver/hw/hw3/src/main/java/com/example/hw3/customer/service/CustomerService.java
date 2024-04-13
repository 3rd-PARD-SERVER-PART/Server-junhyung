package com.example.hw3.customer.service;


import com.example.hw3.customer.dto.CustomerDto;
import com.example.hw3.customer.entity.Customer;
import com.example.hw3.customer.repo.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
//이제는 더이상 repository 에서는 코드 작성을 해주지 않아도 괜찮다 ->JPA로인해서
public class CustomerService {
    private final CustomerRepository customerRepository;
    public void save(CustomerDto customerDto){
        Customer customer = Customer.builder()
                .customerName(customerDto.getName())
                .customerOrder(customerDto.getBurgerOrder())
                .customerJinsang(customerDto.getJinsang())
                .customerVIP(customerDto.getVip())
                .build();
        customerRepository.save(customer);
    }

    public CustomerDto read(Long customerId){
        Customer customer = customerRepository.findById(customerId).get();
        return CustomerDto.builder()
                .name(customer.getCustomerName())
                .burgerOrder(customer.getCustomerOrder())
                .jinsang(customer.getCustomerJinsang())
                .vip(customer.getCustomerVIP())
                .build();
    }

    public List<CustomerDto> readAll(){
        List<Customer> customers = customerRepository.findAll();
        // 스트림 -> List 중 간 값들을 일일이 바궈줄수 있게 하는 자바 문법.
        List<CustomerDto> customerDtos = customers.stream().map(customer ->
                CustomerDto.builder()
                        .name(customer.getCustomerName())
                        .burgerOrder(customer.getCustomerOrder())
                        .jinsang(customer.getCustomerJinsang())
                        .vip(customer.getCustomerVIP())
                        .build()).toList();
        return customerDtos;
    }

    public void update(Long customerId, CustomerDto customerDto){
        Customer customer = customerRepository.findById(customerId).get();

        customer.setCustomerName(customerDto.getName());
        customer.setCustomerOrder(customerDto.getBurgerOrder());
        customer.setCustomerJinsang(customerDto.getJinsang());
        customer.setCustomerVIP(customerDto.getVip());

        customerRepository.save(customer);
    }

    public void delete(Long customerId){
        customerRepository.deleteById(customerId);
    }

    // custom methods from this point on...!
    //Order 로 customer찾기
    public String getCustomerName(String customerOrder){
        Customer customer = customerRepository.findByCustomerOrder(customerOrder);
        return customer.getCustomerName();
    }

    public String getCustomerJinsang(String customerName){
        Customer customer = customerRepository.findByCustomerJinsang(customerName);
        return customer.getCustomerJinsang();
    }

    public String getCustomerVIP(String customerName){
        Customer customer = customerRepository.findByCustomerVIP(customerName);
        return customer.getCustomerVIP();
    }
}
