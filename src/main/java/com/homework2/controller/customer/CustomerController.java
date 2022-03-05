package com.homework2.controller.customer;

import com.homework2.domain.Currency;
import com.homework2.domain.Customer;
import com.homework2.service.customer.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @PostMapping("/")
    public Customer save(
            @RequestBody Customer c) {
//        service.save(c);
        return c;
    }

    @DeleteMapping("/")
    public boolean delete(
            @RequestBody Customer c){
        return service.delete(c);
    }

    @DeleteMapping("/all")
    public void deleteAll(
            @RequestBody List<Customer> lc){
        service.deleteAll(lc);
    }

    @PostMapping("/all")
    public void saveAll(
            @RequestBody List<Customer> lc){
        service.saveAll(lc);
    }

    @GetMapping("all")
    public List<Customer> findAll(){
        return service.findAll();
    }

    @DeleteMapping("{id}")
    public boolean deleteById( @PathVariable("id") Long id){
        return service.deleteById(id - 1);
    }

    @GetMapping("{id}")
    public Customer getOne( @PathVariable("id") Long id){
        return service.getOne(id - 1);
    }
}

/*
  - Изменить данные пользователя
  - Создать счет для конкретного пользователя
  - Удалить счет у пользователя
  */