package com.gylgroup.fyc.domain.models;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public abstract class Invoice {
    private Long id;
    private LocalDateTime releaseDate;
    private LocalDateTime receptionDate;
    private BigDecimal amount;
    private InvoiceState invoiceState;
    private Provider provider;

    public Invoice() {
    }

    public Invoice(Long id, LocalDateTime releaseDate, LocalDateTime receptionDate, BigDecimal amount, InvoiceState invoiceState, Provider provider) {
        this.id = id;
        this.releaseDate = releaseDate;
        this.receptionDate = receptionDate;
        this.amount = amount;
        this.invoiceState = invoiceState;
        this.provider = provider;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDateTime releaseDate) {
        this.releaseDate = releaseDate;
    }

    public LocalDateTime getReceptionDate() {
        return receptionDate;
    }

    public void setReceptionDate(LocalDateTime receptionDate) {
        this.receptionDate = receptionDate;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public InvoiceState getInvoiceState() {
        return invoiceState;
    }

    public void setInvoiceState(InvoiceState invoiceState) {
        this.invoiceState = invoiceState;
    }

    public Provider getProvider() {
        return provider;
    }

    public void setProvider(Provider provider) {
        this.provider = provider;
    }
}
