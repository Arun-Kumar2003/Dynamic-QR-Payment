package com.qr.merchantqr.controller;

import com.qr.merchantqr.dto.PaymentRequest;
import com.qr.merchantqr.dto.PaymentResponse;
import com.qr.merchantqr.service.PaymentService;

import jakarta.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/payments")
@CrossOrigin(origins = "http://localhost:5173")
public class PaymentController {

    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping
    public ResponseEntity<PaymentResponse> createPayment(
            @Valid @RequestBody PaymentRequest request) {

        PaymentResponse response =
                paymentService.createPayment(request);

        return ResponseEntity.ok(response);
    }
}