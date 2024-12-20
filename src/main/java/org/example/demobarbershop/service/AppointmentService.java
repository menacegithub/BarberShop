package org.example.demobarbershop.service;

import org.example.demobarbershop.model.Appointment;
import org.example.demobarbershop.model.Result;
import org.example.demobarbershop.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentService {
    @Autowired
    private AppointmentRepository appointmentRepository;

    public List<Appointment> getAll() {
        return appointmentRepository.findAll();
    }

    public Appointment getById(Integer id) {
        return appointmentRepository.findById(id).orElse(null);
    }

    public Appointment create(Appointment appointment) {
        return appointmentRepository.save(appointment);
    }

    public Result update(Integer id, Appointment updatedAppointment) {
        Appointment existingAppointment = appointmentRepository.findById(id).orElse(null);
        if (existingAppointment == null) {
            return new Result(false, "Appointment not found");
        }
        existingAppointment.setDate(updatedAppointment.getDate());
        existingAppointment.setBarber(updatedAppointment.getBarber());
        appointmentRepository.save(existingAppointment);
        return new Result(true, "Appointment updated successfully");
    }

    public Result delete(Integer id) {
        if (!appointmentRepository.existsById(id)) {
            return new Result(false, "Appointment not found");
        }
        appointmentRepository.deleteById(id);
        return new Result(true, "Appointment deleted successfully");
    }
}

