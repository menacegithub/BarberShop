package org.example.demobarbershop.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ScheduleDto {
    private Long id; // Faqat ma'lumotlarni qaytarishda kerak
    private Long barberId; // Ustani bog'lash uchun
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private boolean isAvailable;
}
