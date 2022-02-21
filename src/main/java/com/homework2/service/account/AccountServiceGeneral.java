package com.homework2.service.account;

import com.homework2.DAO.AccountDaoGeneral;
import com.homework2.domain.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceGeneral {

    @Autowired
    AccountDaoGeneral<Account> accountDao;

    public Account save(Account a){
        accountDao.save(a);
        return a;
    }

    public boolean delete(Account a) {
        return accountDao.delete(a);
    }

    public void deleteAll(List<Account> entities) {
        accountDao.deleteAll(entities);
    }

    public void saveAll(List<Account> entities) {
        accountDao.saveAll(entities);
    }

    public List<Account> findAll() {
        return accountDao.findAll();
    }

    public boolean deleteById(long id) {
        return accountDao.deleteById(id);
    }

    public Account getOne(long id) {
        return accountDao.getOne(id);
    }

}
