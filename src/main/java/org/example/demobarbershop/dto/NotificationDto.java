package org.example.demobarbershop.dto;

import lombok.Data;

import java.time.LocalDateTime;
@Data
public class NotificationDto {
    private Integer id; // Faqat ma'lumotlarni qaytarishda kerak
    private String message;
    private LocalDateTime sentAt;
    private boolean read;
    private Integer userId; //
}
