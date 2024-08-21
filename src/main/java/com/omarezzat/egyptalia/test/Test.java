package com.omarezzat.egyptalia.test;

import com.mailersend.sdk.MailerSend;
import com.mailersend.sdk.MailerSendResponse;
import com.mailersend.sdk.emails.Email;
import com.mailersend.sdk.exceptions.MailerSendException;
import com.omarezzat.egyptalia.model.Product;
import com.omarezzat.egyptalia.model.Review;
import com.omarezzat.egyptalia.repository.ProductRepository;
import com.omarezzat.egyptalia.repository.ReviewRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Component
@RequiredArgsConstructor
public class Test {
    private final Environment env;
    private final ReviewRepository reviewRepository;
    private final ProductRepository productRepository;

//    @Bean
//    @Transactional
//    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
//        return args -> {
//            Product product1 = new Product("chilled_fish_name", "chilled_fish_desc","fish/fish-1.png",125.0);
//            Product product2 = new Product("chilled_fish_name", "Fish With Chill","fish/fish-1.png",134.5);
//            Product product3 = new Product("chilled_fish_name", "Fish With Oil","fish/fish-1.png",125.0);
//            Product product4 = new Product("Chilled Fish", "Fish With Chill","fish/fish-1.png",134.5);
//            Product product5 = new Product("Oiled Fish", "Fish With Oil","fish/fish-1.png",125.0);
//            Product product6 = new Product("Chilled Fish", "Fish With Chill","fish/fish-1.png",134.5);
//            System.out.println(product1.getRating());
//            productRepository.saveAll(List.of(product2, product3, product4, product5, product6));
//            for (Product product : List.of( product2, product3, product4, product5, product6)) {
//                product.setRating((int) (Math.random()*5 +1));
//            }
//            productRepository.saveAll(List.of(product1, product2, product3, product4, product5, product6));
//
//            Review r1 = new Review(product1, "Good", "Omar",4);
//            Review r2 = new Review(product1, "Bad", "Ezzat",1);
////            Optional<Product> p =productRepository.findById(1L);
//            System.out.println(product1.getReviews());
//            product1.updateRating();
//            productRepository.save(product1);
//            System.out.println(product1.getRating());
//            reviewRepository.save(r1);
//            reviewRepository.save(r2);
//            Optional<Product> p1 = productRepository.findById(1L);
//            System.out.println(p1);
//            List<Review> reviews = reviewRepository.findAllByProduct(p1.get());
//            System.out.println(reviews);
//            System.out.println();
//
//        };
//    }
@Bean
    @Transactional
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
        return args -> {
            Product product1 = new Product("prod_crab_name", "prod_crab_desc","fish/fish-1.png");
            productRepository.save(product1);

        };
    }



}
