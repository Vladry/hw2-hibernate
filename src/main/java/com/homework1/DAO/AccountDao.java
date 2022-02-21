package com.homework1.DAO;

import com.homework1.domain.Account;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDao<T> extends abstractDao<Account> {


    public boolean putAmount(String accNum, Double amount){
        Account acc = col.stream().filter(a-> a.getNumber().equals(accNum)).findFirst().orElse(null);
        if(acc !=null ){
            int index = col.indexOf(acc);
            acc.setBalance(acc.getBalance() + amount);
            col.add(index, acc);
            return true;
        }
        return false;
    }

    public boolean drawAmount(String accNum, Double amount){
        Account acc = col.stream().filter(a-> a.getNumber().equals(accNum)).findFirst().orElse(null);
        int index = col.indexOf(acc);
        if(acc !=null && acc.getBalance() >= amount ){
            acc.setBalance(acc.getBalance() - amount);
            col.add(index, acc);
            return true;
        }
        return false;
    }

}
