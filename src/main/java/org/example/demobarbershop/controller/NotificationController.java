package org.example.demobarbershop.controller;

import org.example.demobarbershop.model.Notification;
import org.example.demobarbershop.model.Result;
import org.example.demobarbershop.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notifications")
public class NotificationController {
    @Autowired
    private NotificationService notificationService;

    @GetMapping
    public List<Notification> getAll() {
        return notificationService.getAll();
    }

    @GetMapping("/{id}")
    public Notification getById(@PathVariable Integer id) {
        return notificationService.getById(id);
    }

    @PostMapping
    public Result create(@RequestBody Notification notification) {
        return notificationService.create(notification);
    }

    @PutMapping("/{id}")
    public Result update(@PathVariable Integer id, @RequestBody Notification notification) {
        return notificationService.update(id, notification);
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        return notificationService.delete(id);
    }
}
