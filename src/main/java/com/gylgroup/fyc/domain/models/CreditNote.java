package com.gylgroup.fyc.domain.models;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class CreditNote {
    private Long id;
    private BigDecimal amount;
    private Invoice invoice;
    private LocalDateTime releaseDate;
    private String observationsDetails;

    public CreditNote() {
    }

    public CreditNote(Long id, BigDecimal amount, Invoice invoice, LocalDateTime releaseDate, String observationsDetails) {
        this.id = id;
        this.amount = amount;
        this.invoice = invoice;
        this.releaseDate = releaseDate;
        this.observationsDetails = observationsDetails;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Invoice getInvoice() {
        return invoice;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }

    public LocalDateTime getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDateTime releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getObservationsDetails() {
        return observationsDetails;
    }

    public void setObservationsDetails(String observationsDetails) {
        this.observationsDetails = observationsDetails;
    }
}
