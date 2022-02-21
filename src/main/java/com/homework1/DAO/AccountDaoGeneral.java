package com.homework1.DAO;

import com.homework1.domain.Account;
import com.homework1.domain.Customer;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDaoGeneral<T> extends abstractDao<Account> {

    @Override
    public Account save(Account obj) {
        Account newAccount = new Account(obj.getCurrency(), obj.getCustomer());
        col.add(newAccount);
        return obj;
    }

}
