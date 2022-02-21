package com.homework2.controller.account;

import com.homework2.service.account.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

}

/*
  - AccountController должен иметь следующие методы:
  - Пополнить счет (принимает номер счета и сумму)
  - Снять деньги со счета (принимает номер счета и сумму, выполняется только если на счету достаточно денег)
  - Перевести деньги на другой счет (принимает два номера счета и сумму, выполняется только если на счету достаточно денег)
- При переводе денег на другой счет, если счета в разной валюте, пока что это можно поригнорировать и просто перевести нужную сумму без конвертации
*/