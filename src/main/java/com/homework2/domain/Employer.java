package com.homework2.domain;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "employers")
public class Employer extends AbstractEntity {
    private String name;
    private String street;
    private String address;

    @ManyToMany(fetch = FetchType.EAGER)
//    @JoinTable(name = "customers_employers")  -эту строку нельзя, т.к. она уже есть в Customer!
    private Set<Customer> customers;


}
