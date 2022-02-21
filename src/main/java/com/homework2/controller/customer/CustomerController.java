package com.homework2.controller.customer;

import com.homework2.domain.Currency;
import com.homework2.domain.Customer;
import com.homework2.service.customer.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CustomerController {

@Autowired
CustomerService service;

@PutMapping("update/customers")
    public Customer update(
            @RequestBody Customer customer, Long id){
        return service.update(customer, id);
    }

    @PostMapping("customers/account")
    public Customer create(
            @RequestBody Currency currency, Long id){
        return service.createAccount(currency, id);
    }

    @PutMapping("customers/account")

    public Customer delete(
            @RequestBody String accNumber, Long id){
        return service.deleteAccount(accNumber, id);
    }

}

/*
  - Изменить данные пользователя
  - Создать счет для конкретного пользователя
  - Удалить счет у пользователя
  */