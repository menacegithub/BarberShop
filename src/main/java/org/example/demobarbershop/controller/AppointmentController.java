package org.example.demobarbershop.controller;

import org.example.demobarbershop.model.Appointment;
import org.example.demobarbershop.model.Result;
import org.example.demobarbershop.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/appointments")
public class AppointmentController {
    @Autowired
    private AppointmentService appointmentService;

    @GetMapping
    public List<Appointment> getAll() {
        return appointmentService.getAll();
    }

    @GetMapping("/{id}")
    public Appointment getById(@PathVariable Integer id) {
        return appointmentService.getById(id);
    }

    @PostMapping
    public Appointment create(@RequestBody Appointment appointment) {
        return appointmentService.create(appointment);
    }

    @PutMapping("/{id}")
    public Result update(@PathVariable Integer id, @RequestBody Appointment appointment) {
        return appointmentService.update(id, appointment);
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        return appointmentService.delete(id);
    }
}
