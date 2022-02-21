package com.homework1.service.customer;

import com.homework1.DAO.AccountDao;
import com.homework1.DAO.CustomerDao;
import com.homework1.domain.Account;
import com.homework1.domain.Currency;
import com.homework1.domain.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    CustomerDao<Customer> customerDao;
    @Autowired
    AccountDao<Account> accountDao;

    public Customer update(Customer customer, Long id){
        return customerDao.update(customer, id);
    }

    public Customer createAccount(Currency currency, Long id){
        return customerDao.createAccount(currency, id);
    }

    public Customer deleteAccount(String accNumber, Long id){
        return customerDao.deleteAccount(accNumber, id);
    }


}
/*
  - Изменить данные пользователя
  - Создать счет для конкретного пользователя
  - Удалить счет у пользователя
  */