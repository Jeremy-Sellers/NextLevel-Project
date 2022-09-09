package com.personal.nextlevel.repository;

import com.personal.nextlevel.models.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {
    Review findById(long id);
    Review findByReviewTitle(String title);
}
