package com.homework2.DAO;

import com.homework2.domain.Account;
import com.homework2.domain.Currency;
import com.homework2.domain.Customer;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class CustomerDao<T> extends abstractDao<Customer> {

    @PersistenceUnit
    EntityManagerFactory emf;

    public Customer update(Customer customer, Long id) {
        EntityManager em = emf.createEntityManager();
        Customer cust_ = em.find(Customer.class, id);
        if(cust_ != null){
            cust_.setAccounts( customer.getAccounts() );
            cust_.setAge( cust_.getAge() );
            cust_.setEmployers( customer.getEmployers() );
            cust_.setName( customer.getName() );
            em.getTransaction().begin();
            em.merge(cust_);
            em.getTransaction().commit();
            em.close();
            return cust_;
        } else {
            em.close();
            return null;
        }
    }

    public Customer createAccount(Currency currency, Long id) {
        Customer cust = col.stream().filter(c -> c.getId().equals(id)).findFirst().orElse(null);
        if (cust != null) {
            int index = col.indexOf(cust);
            cust.getAccounts().add(new Account(currency, cust));
            col.add(index, cust);
            return cust;
        }
        return null;
    }

    public Customer deleteAccount(String accNumber, Long id) {
        Customer cust = col.stream().filter(c -> c.getId().equals(id)).findFirst().orElse(null);
        if (cust != null) {
            int index = col.indexOf(cust);
            Account acc = cust.getAccounts().stream().filter(a-> a.getNumber().equals(accNumber)).findFirst().orElse(null);
            cust.getAccounts().remove(acc);
            col.add(index, cust);
            return cust;
        }
        return null;
    }

    @Override
    public Customer save(Customer obj) {
        Customer newCustomer = new Customer(obj.getName(), obj.getEmail(), obj.getAge());
        col.add(newCustomer);
        return obj;
    }

    @Override
    public void saveAll(List<Customer> entities) {
        List<Customer> lc = entities.stream().map(obj->
                        new Customer(obj.getName(), obj.getEmail(), obj.getAge())
                ).collect(Collectors.toList());
        col.addAll(lc);
    }

}
