package org.example.demobarbershop.service;

import org.example.demobarbershop.model.Result;
import org.example.demobarbershop.model.Servicee;
import org.example.demobarbershop.repository.ServiceeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceeService {
    @Autowired
    private ServiceeRepository serviceRepository;

    public List<Servicee> getAll() {
        return serviceRepository.findAll();
    }

    public Servicee getById(Integer id) {
        return serviceRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Servicee not found with id: " + id));
    }

    public Result create(Servicee service) {
        if (service == null || service.getName() == null || service.getPrice() == null) {
            return new Result(false, "Service data is incomplete");
        }

        Servicee servicee = new Servicee();
        servicee.setName(service.getName());
        servicee.setPrice(service.getPrice());
        servicee.setDuration(service.getDuration());
        serviceRepository.save(servicee);
        return new Result(true, "Service created");
    }

    public Result update(Integer id, Servicee newServicee) {
        Optional<Servicee> optionalServicee = serviceRepository.findById(id);
        if (optionalServicee.isPresent()) {
            Servicee existingServicee = optionalServicee.get();
            existingServicee.setName(newServicee.getName());
            existingServicee.setDescription(newServicee.getDescription());
            existingServicee.setPrice(newServicee.getPrice());
            serviceRepository.save(existingServicee);
            return new Result(true, "Servicee updated successfully");
        }
        return new Result(false, "Servicee not found");
    }

    public Result delete(Integer id) {
        if (serviceRepository.existsById(id)) {
            serviceRepository.deleteById(id);
            return new Result(true, "Servicee deleted successfully");
        }
        return new Result(false, "Servicee not found");
    }
}
