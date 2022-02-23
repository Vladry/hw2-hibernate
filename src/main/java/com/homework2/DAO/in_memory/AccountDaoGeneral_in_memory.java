package com.homework2.DAO.in_memory;

import com.homework2.DAO.abstractDao;
import com.homework2.domain.Account;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDaoGeneral_in_memory<T> extends abstractDao<Account> {

    @Override
    public Account save(Account obj) {
        Account newAccount = new Account(obj.getCurrency(), obj.getCustomer());
        col.add(newAccount);
        return obj;
    }

}
