package com.gylgroup.fyc.infrastructure.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "providers")
@PrimaryKeyJoinColumn(name = "user_id")
public class ProviderEntity extends UserEntity {

    @Column(unique = true, nullable = false, length = 11)
    private String cuit;
    private String businessName;
    private String address;
    private String phone;

    public String getCuit() { return cuit; }
    public void setCuit(String cuit) { this.cuit = cuit; }
    public String getBusinessName() { return businessName; }
    public void setBusinessName(String businessName) { this.businessName = businessName; }
    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }
    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }
}