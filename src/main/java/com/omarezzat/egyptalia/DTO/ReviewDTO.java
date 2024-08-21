package com.omarezzat.egyptalia.DTO;

import lombok.Builder;

@Builder
public record ReviewDTO( int numberOfReviewers , double newAverageRating) {
}
