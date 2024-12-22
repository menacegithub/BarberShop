package org.example.demobarbershop.controller;

import org.example.demobarbershop.model.Result;
import org.example.demobarbershop.model.Servicee;
import org.example.demobarbershop.service.ServiceeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/services")
public class ServiceeController {

    @Autowired
    private ServiceeService serviceService;

    @GetMapping
    public List<Servicee> getAll() {
        return serviceService.getAll();
    }

    @GetMapping("/{id}")
    public Servicee getById(@PathVariable Integer id) {
        return serviceService.getById(id);
    }

    @PostMapping
    public Result create(@RequestBody Servicee service) {
        return serviceService.create(service);
    }

    @PutMapping("/{id}")
    public Result update(@PathVariable Integer id, @RequestBody Servicee service) {
        return serviceService.update(id, service);
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        return serviceService.delete(id);
    }
}
