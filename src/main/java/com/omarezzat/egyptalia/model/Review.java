package com.omarezzat.egyptalia.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Data
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "message" )
    private String message;
    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false , foreignKey = @ForeignKey(name = "review_product_fk"))
    @JsonBackReference
    private Product product;
    @Column(name = "rating",nullable = false)
    private int rating;
    public Review(Product product, String message, String name,int rating) {
        this.product = product;
        this.message = message;
        this.name = name;
        this.rating = rating;
        product.getReviews().add(this);
    }


}
