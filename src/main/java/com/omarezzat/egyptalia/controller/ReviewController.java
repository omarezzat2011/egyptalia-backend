package com.omarezzat.egyptalia.controller;

import com.omarezzat.egyptalia.model.Product;
import com.omarezzat.egyptalia.model.Review;
import com.omarezzat.egyptalia.model.ReviewRequest;
import com.omarezzat.egyptalia.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/reviews")
@RequiredArgsConstructor
public class ReviewController {
    private final ReviewService reviewService;

    @PostMapping("add")
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<Object> addReview(@RequestBody ReviewRequest reviewRequest ) {

        return reviewService.addReviewForProduct(reviewRequest);
    }
}
