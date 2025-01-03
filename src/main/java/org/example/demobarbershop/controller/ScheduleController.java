package org.example.demobarbershop.controller;

import org.example.demobarbershop.model.Result;
import org.example.demobarbershop.model.Schedule;
import org.example.demobarbershop.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/schedules")
public class ScheduleController {

    @Autowired
     ScheduleService scheduleService;


    @GetMapping
    public List<Schedule> getAll() {
        return scheduleService.getAll();
    }

    @GetMapping("/{id}")
    public Schedule getById(@PathVariable Integer id) {
        return scheduleService.getById(id);
    }

    @PostMapping
    public Result create(@RequestBody Schedule schedule) {
        return scheduleService.create(schedule);
    }

    @PutMapping("/{id}")
    public Result update(@PathVariable Integer id, @RequestBody Schedule schedule) {
        return scheduleService.update(id, schedule);
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        return scheduleService.delete(id);
    }
}
