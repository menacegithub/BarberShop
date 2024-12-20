package org.example.demobarbershop.service;

import org.example.demobarbershop.model.Result;
import org.example.demobarbershop.model.Review;
import org.example.demobarbershop.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    public List<Review> getAll() {
        return reviewRepository.findAll();
    }

    public Review getById(Integer id) {
        return reviewRepository.findById(id).orElse(null);
    }

    public Review create(Review review) {
        return reviewRepository.save(review);
    }

    public Result update(Integer id, Review updatedReview) {
        Review existingReview = reviewRepository.findById(id).orElse(null);
        if (existingReview == null) {
            return new Result(false, "Review not found");
        }
        existingReview.setComment(updatedReview.getComment());
        existingReview.setRating(updatedReview.getRating());
        reviewRepository.save(existingReview);
        return new Result(true, "Review updated successfully");
    }

    public Result delete(Integer id) {
        if (!reviewRepository.existsById(id)) {
            return new Result(false, "Review not found");
        }
        reviewRepository.deleteById(id);
        return new Result(true, "Review deleted successfully");
    }
}
