package org.example.demobarbershop.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.demobarbershop.model.entity.PaymentMethod;
import org.example.demobarbershop.model.entity.PaymentStatus;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @OneToOne
    private Appointment appointment;
    @Column(nullable = false)
    private Double amount;
    private PaymentMethod paymentMethod;
    private PaymentStatus paymentStatus;

}
