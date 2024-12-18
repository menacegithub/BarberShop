package org.example.demobarbershop.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
//    paymentMethod (Enum) - To'lov usuli (CARD, CASH).
//    paymentStatus (Enum) - To'lov holati (PENDING, PAID, FAILED).

}
