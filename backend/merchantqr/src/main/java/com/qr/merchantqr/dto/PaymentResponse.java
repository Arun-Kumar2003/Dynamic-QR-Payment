package com.qr.merchantqr.dto;

import java.math.BigDecimal;

public class PaymentResponse {

    private String orderId;
    private BigDecimal amount;
    private String currency;
    private String status;
    private String qrData;

    public PaymentResponse() {
    }

    public PaymentResponse(
            String orderId,
            BigDecimal amount,
            String currency,
            String status,
            String qrData) {

        this.orderId = orderId;
        this.amount = amount;
        this.currency = currency;
        this.status = status;
        this.qrData = qrData;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getQrData() {
        return qrData;
    }

    public void setQrData(String qrData) {
        this.qrData = qrData;
    }
}