package org.example.demobarbershop.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.demobarbershop.model.entity.AppointmentStatus;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private LocalDateTime appointmentTime;

    @ManyToOne
    private User user;

    @ManyToOne
    private Barber barber;

    @ManyToOne
    private Servicee servicee;

    @Column(nullable = false)
    private LocalDateTime date;

    @Column(nullable = false)
    private AppointmentStatus status;

}
