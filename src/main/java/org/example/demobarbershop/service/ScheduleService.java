package org.example.demobarbershop.service;

import org.example.demobarbershop.model.Result;
import org.example.demobarbershop.model.Schedule;
import org.example.demobarbershop.repository.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ScheduleService {
    @Autowired
    private ScheduleRepository scheduleRepository;

    // Get all schedules
    public List<Schedule> getAll() {
        return scheduleRepository.findAll();
    }

    // Get schedule by ID
    public Schedule getById(Integer id) {
        return scheduleRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Schedule not found with id: " + id));
    }

    // Create a new schedule
    public Schedule create(Schedule schedule) {
        if (schedule == null || schedule.getBarber() == null || schedule.getStartTime() == null || schedule.getEndTime() == null) {
            throw new IllegalArgumentException("Schedule data is incomplete");
        }
        schedule.setBarber(schedule.getBarber());
        schedule.setStartTime(schedule.getStartTime());
        schedule.setEndTime(schedule.getEndTime());
        return scheduleRepository.save(schedule);
    }

    // Update an existing schedule
    public Result update(Integer id, Schedule newSchedule) {
        Optional<Schedule> optionalSchedule = scheduleRepository.findById(id);
        if (optionalSchedule.isPresent()) {
            Schedule existingSchedule = optionalSchedule.get();
            existingSchedule.setBarber(newSchedule.getBarber());
            scheduleRepository.save(existingSchedule);
            return new Result(true, "Schedule updated successfully");
        }
        return new Result(false, "Schedule not found");
    }

    // Delete a schedule
    public Result delete(Integer id) {
        if (scheduleRepository.existsById(id)) {
            scheduleRepository.deleteById(id);
            return new Result(true, "Schedule deleted successfully");
        }
        return new Result(false, "Schedule not found");
    }


}
