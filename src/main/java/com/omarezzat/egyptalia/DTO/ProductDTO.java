package com.omarezzat.egyptalia.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProductDTO {
    private Long id ;
    private String name;
    private double price ;
    private String description;
    private double rating ;
    private String imgUrl;
    private int reviewersNumber;

    public ProductDTO(Long id, String name, String description, double rating, String imgUrl, int size) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.rating = rating;
        this.imgUrl = imgUrl;
        this.reviewersNumber = size;

    }
}
