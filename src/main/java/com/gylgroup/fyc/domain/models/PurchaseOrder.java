package com.gylgroup.fyc.domain.models;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class PurchaseOrder {
    private Long id;
    private Long orderNumber;
    private LocalDateTime releaseDate;
    private LocalDateTime receptionDate;
    private BigDecimal amount;
    private Provider provider;

    public PurchaseOrder() {
    }

    public PurchaseOrder(Long id, Long orderNumber, LocalDateTime releaseDate, LocalDateTime receptionDate, BigDecimal amount, Provider provider) {
        this.id = id;
        this.orderNumber = orderNumber;
        this.releaseDate = releaseDate;
        this.receptionDate = receptionDate;
        this.amount = amount;
        this.provider = provider;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(Long orderNumber) {
        this.orderNumber = orderNumber;
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

    public Provider getProvider() {
        return provider;
    }

    public void setProvider(Provider provider) {
        this.provider = provider;
    }
}
