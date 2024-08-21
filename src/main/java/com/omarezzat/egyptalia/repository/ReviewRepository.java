package com.omarezzat.egyptalia.repository;

import com.omarezzat.egyptalia.model.Product;
import com.omarezzat.egyptalia.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long> {

    List<Review> findAllByProduct(Product product);
}
