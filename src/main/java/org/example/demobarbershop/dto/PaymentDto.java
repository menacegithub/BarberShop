package org.example.demobarbershop.dto;

import lombok.Data;
import org.example.demobarbershop.model.entity.PaymentMethod;
import org.example.demobarbershop.model.entity.PaymentStatus;

import java.time.LocalDateTime;

@Data
public class PaymentDto {
    private Integer id; // Faqat ma'lumotlarni qaytarishda kerak
    private Integer appointmentId; // Bronni bog'lash uchun
    private Double amount;
    private PaymentMethod paymentMethod; // CREDIT_CARD, CASH
    private PaymentStatus status; // PAID, FAILED
    private LocalDateTime paymentDate;
}
