package com.homework1.domain;

import java.util.ArrayList;
import java.util.List;

public class Customer {

    private Long id;
    private String name;
    private String email;
    private Integer age;
    private List<Account> accounts;

    public Customer() {
    }

    public Customer(String name, String email, int age) {
        this.name = name;
        this.age = age;
        this.email = email;
        this.accounts = new ArrayList<>();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        Customer c = (Customer) o;
        return this.name.equals(c.name) && this.email.equals(c.email) && this.age.equals(c.age);
    }

    @Override
    public int hashCode() {
        int h1 = 31 * this.name.hashCode();
        int h2 = 15 * this.email.hashCode();
        int h3 = 37 * this.age;

        return h1+h2+h3;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }
}
