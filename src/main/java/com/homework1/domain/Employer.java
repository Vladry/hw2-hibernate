package com.homework1.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "employers")
public class Employer extends AbstractEntity {

    private String street;
    private String address;
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "employer")
    private Set<Customer> customers;


}
