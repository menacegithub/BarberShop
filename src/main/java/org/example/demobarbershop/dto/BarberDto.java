package org.example.demobarbershop.dto;

import lombok.Data;

@Data
public class BarberDto {

    private Integer id; // Faqat ma'lumotlarni qaytarishda kerak
    private String name;
    private String specialization;
    private String phoneNumber;
    private Double rating; // Faqat o'qish uchun

}
