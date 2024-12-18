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

public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    private User user;

    @ManyToOne
    private Barber barber;

    @Column(nullable = false)
    private Double rating;

    @Column(nullable = false)
    private String comment;

    @Column(nullable = false)
    private LocalDateTime date;

}
