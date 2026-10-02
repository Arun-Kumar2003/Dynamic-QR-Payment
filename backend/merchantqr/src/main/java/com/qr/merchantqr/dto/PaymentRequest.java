package com.qr.merchantqr.dto;

import java.math.BigDecimal;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;

public class PaymentRequest {

    @NotNull(message = "Amount is required")
    @DecimalMin(value = "1.00", message = "Amount must be greater than 0")
    private BigDecimal amount;

    public PaymentRequest() {
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}