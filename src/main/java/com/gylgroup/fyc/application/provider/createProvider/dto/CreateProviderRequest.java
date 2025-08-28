package com.gylgroup.fyc.application.provider.createProvider.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;


public class CreateProviderRequest {

    @NotBlank(message = "La razón social no puede estar vacía.")
    private String companyName;

    @NotBlank(message = "El CUIT no puede estar vacío.")
    private String cuit;

    @NotBlank(message = "El correo electrónico no puede estar vacío.")
    @Email(message = "El formato del correo electrónico es inválido.")
    private String email;

    private String address;



    public String getCompanyName() { return companyName; }
    public void setCompanyName(String companyName) { this.companyName = companyName; }
    public String getCuit() { return cuit; }
    public void setCuit(String cuit) { this.cuit = cuit; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }
}