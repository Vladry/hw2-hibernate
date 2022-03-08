package com.homework2.DAO;

import com.homework2.domain.Account;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

@Repository
public class AccountDao<T> extends abstractDao<Account> {

    @PersistenceUnit
    EntityManagerFactory emf;

    public boolean putAmount(String accNum, Double amount) {
        EntityManager em = emf.createEntityManager();
        Query query = em.createQuery("select a from Account a where a.number = :accNum")
                .setParameter("accNum", accNum);
        Account acc = (Account) query.getSingleResult();
        if (acc != null) {
            em.getTransaction().begin();
            acc.setBalance(acc.getBalance() + amount);
            em.merge(acc);
            em.close();
            em.getTransaction().commit();
            return true;
        }
        em.close();
        return false;
    }

    public boolean drawAmount(String accNum, Double amount) {
        EntityManager em = emf.createEntityManager();
        Query query = em.createQuery("select a from Account a where a.number = :accNum")
                .setParameter("accNum", accNum);
        Account acc = (Account) query.getSingleResult();
        if (acc != null && acc.getBalance() >= amount) {
            em.getTransaction().begin();
            acc.setBalance(acc.getBalance() + amount);
            em.merge(acc);
            em.close();
            em.getTransaction().commit();
            return true;
        }
        em.close();
        return false;
    }

    @Override
    public Account save(Account obj) {
        System.out.println(obj);
        EntityManager em = emf.createEntityManager();
        Account newAccount = new Account(obj.getCurrency(), obj.getCustomer());
        em.getTransaction().begin();
        em.persist(newAccount);
        em.getTransaction().commit();
        em.close();
        return obj;
    }

}
