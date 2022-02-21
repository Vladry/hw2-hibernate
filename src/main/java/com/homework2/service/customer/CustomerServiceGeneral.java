package com.homework2.service.customer;

import com.homework2.DAO.CustomerDao;
import com.homework2.domain.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceGeneral {

    @Autowired
    CustomerDao<Customer> customerDao;


    public Customer save(Customer c) {
        customerDao.save(c);
        return c;
    }

    public boolean delete(Customer c) {
        return customerDao.delete(c);
    }

    public void deleteAll(List<Customer> entities) {
        customerDao.deleteAll(entities);
    }

    public void saveAll(List<Customer> entities) {
        customerDao.saveAll(entities);
    }

    public List<Customer> findAll() {
        return customerDao.findAll();
    }

    public boolean deleteById(long id) {
        return customerDao.deleteById(id);
    }

    public Customer getOne(long id) {
        return customerDao.getOne(id);
    }
}

/*
  - CustomerController умеет:
  - Получить информацию про отдельного пользователя ???включая его счета???
  - Получить информацию про всех пользователей
  - Создать пользователя
  - Удалить пользователя

  */
