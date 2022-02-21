package com.homework2.service.account;

import com.homework2.DAO.AccountDao;
import com.homework2.domain.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {

    @Autowired
    AccountDao<Account> accountDao;


    public boolean putAmount(String accNum, Double amount) {
        return accountDao.putAmount(accNum, amount);
    }

    public boolean drawAmount(String accNum, Double amount) {
        return accountDao.drawAmount(accNum, amount);
    }

    public boolean transferAmount(String from, String to, Double amount) {
        boolean putSuccess = false;
        boolean drawSuccess = accountDao.drawAmount(from, amount);
        if (drawSuccess) {
            putSuccess = accountDao.putAmount(to, amount);
        } else {
            accountDao.putAmount(from, amount);
            return false;
        }
        if (putSuccess) {
            return true;
        } else {
            accountDao.putAmount(from, amount);
            return false;
        }
    }
}
