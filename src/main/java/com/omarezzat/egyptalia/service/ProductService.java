package com.omarezzat.egyptalia.service;

import com.omarezzat.egyptalia.DTO.ProductDTO;
import com.omarezzat.egyptalia.model.Product;
import com.omarezzat.egyptalia.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public List<ProductDTO> getAllProducts() {
        List<ProductDTO>productDTOS = new ArrayList<>();

        productRepository.findAll().forEach(
                product -> {
                    if (product.getPrice() == null)
                        productDTOS.add(new ProductDTO(product.getId(), product.getName(),
                                 product.getDescription(), product.getRating(), product.getImgUrl(), product.getReviews().size()));
                    else
                        productDTOS.add(new ProductDTO(product.getId(), product.getName(),
                                product.getPrice(), product.getDescription(), product.getRating(), product.getImgUrl(), product.getReviews().size()));
                });
                return productDTOS;
    }
    public List<Product> getTop3Products() {
        Page<Product> top3Products = productRepository.findTop3Products(PageRequest.of(0, 3));
        return top3Products.getContent();
    }

    public Product getProductById(Long id) {
        return productRepository.findById(id).orElse(null);
    }
}
