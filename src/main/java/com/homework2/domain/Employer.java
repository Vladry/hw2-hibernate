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
//    @OneToMany(fetch = FetchType.EAGER, mappedBy = "employer")
//    private Set<Customer> customers;
//    @JoinColumn(name = "customers_id")
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "customers_employers")
    private Set<Customer> customers;


}
