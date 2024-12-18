package org.example.demobarbershop.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    private User user;
    @ManyToOne
    private Barber barber;
    @ManyToOne
    private Servicee servicee;
    @Column(nullable = false)
    private LocalDateTime date;
    //(Enum) - Bron holati (PENDING, CONFIRMED, CANCELLED).
}
