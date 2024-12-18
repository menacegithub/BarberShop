package org.example.demobarbershop.repository;

import org.example.demobarbershop.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Integer> {

}
