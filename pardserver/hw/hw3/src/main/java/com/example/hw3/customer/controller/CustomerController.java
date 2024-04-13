package com.example.hw3.customer.controller;


import com.example.hw3.customer.dto.CustomerDto;
import com.example.hw3.customer.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/customer")
public class CustomerController {
    private final CustomerService customerService;
    @PostMapping("")
    public void save(@RequestBody CustomerDto customerDto){ //http 통신할때 reqeust body 로
        customerService.save(customerDto);
    }

    @GetMapping("/{customerId}")
    public CustomerDto readById(@PathVariable Long customerId){ //id 값 넘겨주는 것은 pathvariable 이 처리해줌.
        return customerService.read(customerId);
    }

    @GetMapping("")
    public List<CustomerDto> readAll(){
        return customerService.readAll();
    }

    @PatchMapping("/{customerId}")
    public void update(@PathVariable Long customerId, @RequestBody CustomerDto customerDto){
        customerService.update(customerId, customerDto);

    }

    @DeleteMapping("/{customerId}")
    public void delete(@PathVariable Long customerId){
        customerService.delete(customerId);
    }


    // request vs response
    // dto 를 만들지 않고 response entity 로 보내줌.
    @GetMapping("/customerOrder")
    public ResponseEntity<String> read(@RequestParam String burgerOrder){
        String returnToClient = customerService.getCustomerName(burgerOrder);

        return new ResponseEntity<>(returnToClient, HttpStatus.OK); // status 200 OK 이다.
    }

    @GetMapping("/customerJinsang")
    public ResponseEntity<String> jinsang(@RequestParam String name){
        String returnToClient = customerService.getCustomerJinsang(name);

        return new ResponseEntity<>(returnToClient, HttpStatus.OK); // status 200 OK 이다.
    }

    @GetMapping("/customerVIP")
    public ResponseEntity<String> vip(@RequestParam String name){
        String returnToClient = customerService.getCustomerVIP(name);

        return new ResponseEntity<>(returnToClient, HttpStatus.OK); // status 200 OK 이다.
    }


}