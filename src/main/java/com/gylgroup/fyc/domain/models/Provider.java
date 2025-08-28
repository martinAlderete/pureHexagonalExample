package com.gylgroup.fyc.domain.models;

import java.time.LocalDateTime;
import java.util.Set;

public class Provider extends User {

    private String cuit;
    private String companyName;
    private boolean primerIngreso;
    private String address;
    private Set<Employee> employees;
    private City city;


    public Provider(Long id, String password, String email, Set<Role> roles, boolean isEnabled, LocalDateTime creationDate, boolean isAccountNonExpired, boolean isAccountNonLocked, boolean isCredentialsNonExpired, String cuit, String companyName, boolean primerIngreso, String address, Set<Employee> employees, City city) {
        super(id, password, email, roles, isEnabled, creationDate, isAccountNonExpired, isAccountNonLocked, isCredentialsNonExpired);
        this.cuit = cuit;
        this.companyName = companyName;
        this.primerIngreso = primerIngreso;
        this.address = address;
        this.employees = employees;
        this.city = city;
    }

    public String getCuit() {
        return cuit;
    }

    public void setCuit(String cuit) {
        this.cuit = cuit;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public boolean isPrimerIngreso() {
        return primerIngreso;
    }

    public void setPrimerIngreso(boolean primerIngreso) {
        this.primerIngreso = primerIngreso;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }
}
