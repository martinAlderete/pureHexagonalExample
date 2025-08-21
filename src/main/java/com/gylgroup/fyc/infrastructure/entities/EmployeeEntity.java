package com.gylgroup.fyc.infrastructure.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "employees")
@PrimaryKeyJoinColumn(name = "user_id")
public class EmployeeEntity extends UserEntity {

    private String name;
    private String lastName;

    public EmployeeEntity() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}