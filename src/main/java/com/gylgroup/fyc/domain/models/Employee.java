package com.gylgroup.fyc.domain.models;

import java.time.LocalDateTime;
import java.util.Set;

public class Employee extends User {

    private String name;
    private String surname;
    private String dni;


    public Employee(Long id, String password, String email, Set<Role> roles, boolean isEnabled, LocalDateTime creationDate, boolean isAccountNonExpired, boolean isAccountNonLocked, boolean isCredentialsNonExpired, String name, String surname, String dni) {
        super(id, password, email, roles, isEnabled, creationDate, isAccountNonExpired, isAccountNonLocked, isCredentialsNonExpired);
        this.name = name;
        this.surname = surname;
        this.dni = dni;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }
}
