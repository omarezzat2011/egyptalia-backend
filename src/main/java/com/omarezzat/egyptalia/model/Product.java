package com.omarezzat.egyptalia.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.ArrayList;
import java.util.DoubleSummaryStatistics;
import java.util.IntSummaryStatistics;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name",nullable = false)
    private String name;
    @Column(name = "price")
    private Double price;
    @Column(name = "description" , nullable = false)
    private String description;
    @OneToMany(mappedBy = "product",fetch = FetchType.EAGER)
    @JsonManagedReference @JsonIgnore
    List<Review> reviews = new ArrayList<>();

    @Column(name = "rating" , nullable = false)
    private double rating;

    String imgUrl = "fish/fish-1.png";

    public Product(String name, String description, String imgUrl, Double price) {
        this.name = name;
        this.description = description;
        this.imgUrl = imgUrl;
        this.price = price;
    }

    public Product(String name, String description, String imgUrl) {
        this.name = name;
        this.description = description;
        this.imgUrl = imgUrl;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    public void updateRating(){
        List<Double> ratings = new ArrayList<>();
        reviews.stream().forEach(r -> ratings.add((double) r.getRating()));
        DoubleSummaryStatistics iss =  ratings.stream().mapToDouble((a) -> a). summaryStatistics();
        setRating(iss.getAverage());
    }
}
