package com.homework1.controller.customer;

import com.homework1.domain.Customer;
import com.homework1.service.customer.CustomerServiceGeneral;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("customers")
public class CustomerControllerGeneral {

@Autowired
CustomerServiceGeneral service;

    @PostMapping("/")
    public Customer save(
            @RequestBody Customer c) {
        service.save(c);
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
    public boolean deleteById( @PathVariable("id") long id){
        return service.deleteById(id - 1);
    }

    @GetMapping("{id}")
    public Customer getOne( @PathVariable("id") long id){
        return service.getOne(id - 1);
    }
}
