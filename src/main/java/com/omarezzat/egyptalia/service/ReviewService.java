package com.omarezzat.egyptalia.service;

import com.omarezzat.egyptalia.DTO.ReviewDTO;
import com.omarezzat.egyptalia.model.Review;
import com.omarezzat.egyptalia.model.ReviewRequest;
import com.omarezzat.egyptalia.repository.ProductRepository;
import com.omarezzat.egyptalia.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.omarezzat.egyptalia.model.Product;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ReviewService {
    private final ReviewRepository reviewRepository;
    private final ProductRepository productRepository;

    public List<Review> getAllProducts() {
        return reviewRepository.findAll();
    }

    public Review getllByProduct(Long id) {
                return reviewRepository.findById(id).orElse(null);
    }

    public ResponseEntity<Object> addReviewForProduct(ReviewRequest reviewRequest) {
        if (reviewRequest.productId() <= 0)
            return ResponseEntity.badRequest().body("Product Id Must Be Postive");
        Optional<Product> product = productRepository.findById(reviewRequest.productId());
        Review review = new Review(product.get(),reviewRequest.message(), reviewRequest.name(), reviewRequest.rating() );
        reviewRepository.save(review);
        product.get().updateRating();
        productRepository.save(product.get());
        return ResponseEntity.ok().body(ReviewDTO.builder().numberOfReviewers(product.get().getReviews().size()).newAverageRating(product.get().getRating()).build());

    }

//    }
}
