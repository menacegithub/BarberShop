package org.example.demobarbershop.controller;

import org.example.demobarbershop.model.Result;
import org.example.demobarbershop.model.Review;
import org.example.demobarbershop.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reviews")
public class ReviewController {
    @Autowired
    private ReviewService reviewService;

    @GetMapping
    public List<Review> getAll() {
        return reviewService.getAll();
    }

    @GetMapping("/{id}")
    public Review getById(@PathVariable Integer id) {
        return reviewService.getById(id);
    }

    @PostMapping
    public Result create(@RequestBody Review review) {
        return reviewService.create(review);
    }

    @PutMapping("/{id}")
    public Result update(@PathVariable Integer id, @RequestBody Review review) {
        return reviewService.update(id, review);
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        return reviewService.delete(id);
    }
}
