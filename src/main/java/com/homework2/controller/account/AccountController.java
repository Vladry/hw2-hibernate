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
