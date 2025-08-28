package com.gylgroup.fyc.domain.models;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class InvoiceTypeA /*extends Invoice*/{

    private Long id;

    public InvoiceTypeA() {
    }

    /*public InvoiceTypeA(Long id, LocalDateTime releaseDate,
                        LocalDateTime receptionDate, BigDecimal amount,
                        InvoiceState invoiceState, Provider provider) {
        super(id,releaseDate, receptionDate, amount, invoiceState,provider);
        this.id = id;
    }*/

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
