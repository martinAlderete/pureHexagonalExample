package com.gylgroup.fyc.application.provider.updateProvider.dto;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;


public class UpdateProviderRequest {

    @NotBlank(message = "La razón social no puede estar vacía.")
    private String companyName;

    @NotBlank(message = "El correo electrónico no puede estar vacío.")
    @Email(message = "El formato del correo electrónico es inválido.")
    private String email;

    private String address;
    private String phone;

    public String getCompanyName() { return companyName; }
    public void setCompanyName(String companyName) { this.companyName = companyName; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }
    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }
}
