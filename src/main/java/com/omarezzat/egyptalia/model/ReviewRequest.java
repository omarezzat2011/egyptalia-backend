package com.omarezzat.egyptalia.model;

public record ReviewRequest(String name,String message , Long productId,int rating ) {
}
