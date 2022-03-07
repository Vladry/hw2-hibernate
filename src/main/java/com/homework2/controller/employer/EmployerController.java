package com.homework2.controller.employer;

import com.homework2.domain.Employer;
import com.homework2.service.EmployerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployerController {

    @Autowired
    EmployerService service;
//
//    @PostMapping("/employer")
//    public void save(@RequestBody() Employer e) {
//        service.save(e);
//    }
//
//    @DeleteMapping("/employer")
//    public void delete(@RequestBody Employer e) {
//        service.delete(e);
//    }
//
//    @DeleteMapping("/employer/all")
//    public void deleteAll(@RequestBody List<Employer> le) {
//        service.deleteAll(le);
//    }
//
//    @PostMapping("/employer")
//    public void saveAll(@RequestBody List<Employer> le) {
//        service.saveAll(le);
//    }
//
//    @PostMapping("/employer")
//    public List<Employer> findAll() {
//        return service.findAll();
//    }
//
//    @GetMapping("/employer/{id}")
//    public void deleteById(@PathVariable("id") Long id) {
//        service.deleteById(id);
//    }
//
//    @PostMapping("/employer/{id}")
//    public void getOne(@PathVariable("id") Long id) {
//        service.getById(id);
//    }

}
