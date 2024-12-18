package org.example.demobarbershop.repository;

import org.example.demobarbershop.model.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationRepository extends JpaRepository<Notification, Integer> {
}
