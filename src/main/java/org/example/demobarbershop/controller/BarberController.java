package org.example.demobarbershop.controller;

import org.example.demobarbershop.model.Barber;
import org.example.demobarbershop.model.Result;
import org.example.demobarbershop.service.BarberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/barbers")
public class BarberController {
    @Autowired
    private BarberService barberService;

    @GetMapping
    public List<Barber> getAll() {
        return barberService.getAll();
    }

    @GetMapping("/{id}")
    public Barber getById(@PathVariable Integer id) {
        return barberService.getById(id);
    }

    @PostMapping
    public Result create(@RequestBody Barber barber) {
        return barberService.create(barber);
    }

    @PutMapping("/{id}")
    public Result update(@PathVariable Integer id, @RequestBody Barber barber) {
        return barberService.update(id, barber);
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        return barberService.delete(id);
    }
}
