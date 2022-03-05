package com.homework2.controller.account;

import com.homework2.domain.Account;
import com.homework2.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("accounts")
public class AccountController {

    @Autowired
    AccountService service;

@PostMapping("put-amount")
public boolean putAmount(
        @RequestBody String accNum, Double amount){
    return service.putAmount(accNum, amount);
}

@PostMapping("draw-amount")
public boolean drawAmount(
        @RequestBody String accNum, Double amount){
    return service.drawAmount(accNum, amount);
}

@PostMapping("make-transfer")
    public boolean transferAmount(
            @RequestBody String from, String to, Double amount){
    return service.transferAmount(from, to, amount);
}

    @PostMapping("/")
    public Account save(
            @RequestBody Account a) {
        service.save(a);
        return a;
    }

    @DeleteMapping("/")
    public boolean delete(
            @RequestBody Account a){
        return service.delete(a);
    }

    @DeleteMapping("/all")
    public void deleteAll(
            @RequestBody List<Account> la){
        service.deleteAll(la);
    }

    @PostMapping("/all")
    public void saveAll(
            @RequestBody List<Account> la){
        service.saveAll(la);
    }

    @GetMapping("all")
    public List<Account> findAll(){
        return service.findAll();
    }

    @DeleteMapping("{id}")
    public boolean deleteByIdL( @PathVariable("id") Long id){
        return service.deleteById(id-1);
    }

    @GetMapping("{id}")
    public Account getOne( @PathVariable("id") Long id){
        return service.getOne(id - 1);
    }

}

/*
  - AccountController должен иметь следующие методы:
  - Пополнить счет (принимает номер счета и сумму)
  - Снять деньги со счета (принимает номер счета и сумму, выполняется только если на счету достаточно денег)
  - Перевести деньги на другой счет (принимает два номера счета и сумму, выполняется только если на счету достаточно денег)
- При переводе денег на другой счет, если счета в разной валюте, пока что это можно поригнорировать и просто перевести нужную сумму без конвертации
*/