package com.orderManagement.api.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    @Id
    @GeneratedValue
    @NonNull
    Long id;
    private String name;
    private String role;

    public Employee(String name,  String role) {
        this.name = name;
        this.role = role;
    }

}
