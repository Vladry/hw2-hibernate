package com.homework1.controller.account;

import com.homework1.domain.Account;
import com.homework1.service.account.AccountServiceGeneral;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("accounts")
public class AccountControllerGeneral {

    @Autowired
    AccountServiceGeneral service;

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
    public boolean deleteById( @PathVariable("id") long id){
        return service.deleteById(id-1);
    }

    @GetMapping("{id}")
    public Account getOne( @PathVariable("id") long id){
        return service.getOne(id - 1);
    }
}
