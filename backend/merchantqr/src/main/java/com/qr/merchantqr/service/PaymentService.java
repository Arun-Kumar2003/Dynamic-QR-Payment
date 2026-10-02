package com.qr.merchantqr.service;

import com.qr.merchantqr.dto.PaymentRequest;
import com.qr.merchantqr.dto.PaymentResponse;
import com.qr.merchantqr.entity.Payment;
import com.qr.merchantqr.repository.paymentRepository;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class PaymentService {

    private final paymentRepository paymentRepository;

    public PaymentService(paymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    public PaymentResponse createPayment(PaymentRequest request) {

        Payment payment = new Payment();

        // Generate order ID
        String orderId = "ORD-" +
                UUID.randomUUID()
                        .toString()
                        .substring(0, 8)
                        .toUpperCase();

        payment.setOrderId(orderId);

        // Set payment details
        payment.setAmount(request.getAmount());
        payment.setCurrency("INR");
        payment.setStatus("CREATED");
        payment.setCreatedAt(LocalDateTime.now());

        // Demo UPI details
        String upiId = "yourupiid@bank.com";
        String name = "College Project";

        // Generate UPI payment data
        String qrData =
                "upi://pay" +
                "?pa=" + upiId +
                "&pn=" + name +
                "&am=" + request.getAmount() +
                "&cu=INR" +
                "&tr=" + orderId;

        // Store QR data
        payment.setQr(qrData);

        // Save to PostgreSQL
        paymentRepository.save(payment);

        // Return response
        return new PaymentResponse(
                payment.getOrderId(),
                payment.getAmount(),
                payment.getCurrency(),
                payment.getStatus(),
                payment.getQr()
        );
    }
}