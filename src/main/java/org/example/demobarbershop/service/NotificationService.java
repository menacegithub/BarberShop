package org.example.demobarbershop.service;

import org.example.demobarbershop.model.Notification;
import org.example.demobarbershop.model.Result;
import org.example.demobarbershop.repository.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificationService {

    @Autowired
    private NotificationRepository notificationRepository;

    public List<Notification> getAll() {
        return notificationRepository.findAll();
    }

    public Notification getById(Integer id) {
        return notificationRepository.findById(id).orElse(null);
    }

    public Notification create(Notification notification) {
        return notificationRepository.save(notification);
    }

    public Result update(Integer id, Notification updatedNotification) {
        Notification existingNotification = notificationRepository.findById(id).orElse(null);
        if (existingNotification == null) {
            return new Result(false, "Notification not found");
        }
        existingNotification.setMessage(updatedNotification.getMessage());
        notificationRepository.save(existingNotification);
        return new Result(true, "Notification updated successfully");
    }

    public Result delete(Integer id) {
        if (!notificationRepository.existsById(id)) {
            return new Result(false, "Notification not found");
        }
        notificationRepository.deleteById(id);
        return new Result(true, "Notification deleted successfully");
    }
}
