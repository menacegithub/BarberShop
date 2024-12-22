package org.example.demobarbershop.service;

import org.example.demobarbershop.model.Barber;
import org.example.demobarbershop.model.Result;
import org.example.demobarbershop.repository.BarberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BarberService {
    @Autowired
    private BarberRepository barberRepository;

    public List<Barber> getAll() {
        return barberRepository.findAll();
    }

    public Barber getById(Integer id) {
        return barberRepository.findById(id).orElse(null);
    }

    public Result create(Barber barber) {
        if (barber == null || barber.getName() == null || barber.getSpecialization() == null) {
            return new Result(false,"Barber data is incomplete");
        }
        Barber barber1 = new Barber();
        barber1.setName(barber.getName());
        barber1.setSpecialization(barber.getSpecialization());
        barber1.setPhoneNumber(barber.getPhoneNumber());
        barberRepository.save(barber);
        return new Result(true,"Barber created");
    }

    public Result update(Integer id, Barber updatedBarber) {
        Barber existingBarber = barberRepository.findById(id).orElse(null);
        if (existingBarber == null) {
            return new Result(false, "Barber not found");
        }
        existingBarber.setName(updatedBarber.getName());
        existingBarber.setPhoneNumber(updatedBarber.getPhoneNumber());
        barberRepository.save(existingBarber);
        return new Result(true, "Barber updated successfully");
    }

    public Result delete(Integer id) {
        if (!barberRepository.existsById(id)) {
            return new Result(false, "Barber not found");
        }
        barberRepository.deleteById(id);
        return new Result(true, "Barber deleted successfully");
    }
}
