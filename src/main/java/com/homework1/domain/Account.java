package com.homework1.domain;

import java.util.UUID;

public class Account {

    Long id;
    String number;
    Currency currency;
    Double balance;
    Customer customer;

    public Account() {}

    public Account(Currency currency, Customer customer) {
        this.number = UUID.randomUUID().toString();
        this.currency = currency;
        this.customer = customer;
        this.balance = 0.0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        Account a = (Account) o;
        return this.number.equals(a.number) /*&& this.currency.equals(a.currency) */
                && this.customer.equals(a.customer);
    }

    @Override
    public int hashCode() {

        int h1 = 31 * this.number.hashCode();
        int h2 = 15 * this.currency.hashCode();
//        int h3 = 37 * this.balance.hashCode();
        int h4 = 15 * this.customer.hashCode();

        return h1+h2/*+h3*/+h4;
    }

    @Override
    public String toString() {
        return null;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
