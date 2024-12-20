package org.example.demobarbershop.repository;

import org.example.demobarbershop.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository <Payment, Integer> {
}
