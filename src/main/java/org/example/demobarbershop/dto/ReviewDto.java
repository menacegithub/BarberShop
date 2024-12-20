package org.example.demobarbershop.dto;

import lombok.Data;

@Data
public class ReviewDto {
    private Integer id; // Faqat ma'lumotlarni qaytarishda kerak
    private Integer userId; // Foydalanuvchini bog'lash uchun
    private Integer barberId; // Ustani bog'lash uchun
    private String comment;
    private Integer rating;
}
