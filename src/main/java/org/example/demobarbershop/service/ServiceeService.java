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

    // Get all services
    public List<Servicee> getAll() {
        return serviceRepository.findAll();
    }

    // Get service by ID
    public Servicee getById(Integer id) {
        return serviceRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Servicee not found with id: " + id));
    }

    // Create a new service
    public Servicee create(Servicee service) {
        return serviceRepository.save(service);
    }

    // Update an existing service
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

    // Delete a service
    public Result delete(Integer id) {
        if (serviceRepository.existsById(id)) {
            serviceRepository.deleteById(id);
            return new Result(true, "Servicee deleted successfully");
        }
        return new Result(false, "Servicee not found");
    }
}
