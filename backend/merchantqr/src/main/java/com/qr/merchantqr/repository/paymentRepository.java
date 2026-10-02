package com.qr.merchantqr.repository;

import com.qr.merchantqr.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;


public interface paymentRepository
        extends JpaRepository<Payment, Integer> {

}