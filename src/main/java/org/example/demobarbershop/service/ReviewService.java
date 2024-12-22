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

    public Result create(Review review) {
        if (review == null || review.getUser() == null || review.getRating() == null || review.getComment() == null) {
            return new Result(false, "Review data is incomplete");
        }
        Review review1 = new Review();
        review1.setUser(review.getUser());
        review1.setRating(review.getRating());
        review1.setComment(review.getComment());
        reviewRepository.save(review);
        return new Result(true, "Review created");
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
