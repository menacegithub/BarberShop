package org.example.demobarbershop.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class AppointmentDto {
    private Integer id; // Faqat ma'lumotlarni qaytarishda kerak
    private LocalDateTime appointmentTime;
    private Integer userId; // Foydalanuvchini bog‘lash uchun
    private Integer barberId; // Ustani bog‘lash uchun
    private Integer serviceId;

}
