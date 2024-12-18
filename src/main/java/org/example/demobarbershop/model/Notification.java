package org.example.demobarbershop.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    private User recipient;
    @Column(nullable = false)
    private String message;
    @Column(nullable = false)
    private LocalDateTime timestamp;
//  status (Enum) - Xabarnoma holati (SENT, READ).

}
