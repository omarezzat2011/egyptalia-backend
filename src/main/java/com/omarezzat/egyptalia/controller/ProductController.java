package com.omarezzat.egyptalia.controller;

import com.omarezzat.egyptalia.DTO.ProductDTO;
import com.omarezzat.egyptalia.model.Product;
import com.omarezzat.egyptalia.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/products")
public class ProductController {
    private final ProductService productService;

    @GetMapping("all")
    @CrossOrigin(origins = "http://localhost:3000")
    public List<ProductDTO> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("top")
    @CrossOrigin
    public List<Product> getAllTopProducts() {
        return productService.getTop3Products();
    }
}
