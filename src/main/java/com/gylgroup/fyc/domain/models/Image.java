package com.gylgroup.fyc.domain.models;

public class Image {
    private Long id;
    private Long orderNumber;
    //private PurchaseOrder orderId;
    //private Invoice invoceId;

    public Image() {}

    /*public Image(Long id, Long orderNumber, PurchaseOrder orderId, Invoice invoceId) {
        this.id = id;
        this.orderNumber = orderNumber;
        this.orderId = orderId;
        this.invoceId = invoceId;
    }*/

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

    /*public PurchaseOrder getOrderId() {
        return orderId;
    }

    public void setOrderId(PurchaseOrder orderId) {
        this.orderId = orderId;
    }

    public Invoice getInvoceId() {
        return invoceId;
    }

    public void setInvoceId(Invoice invoceId) {
        this.invoceId = invoceId;
    }*/
}
