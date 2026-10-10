package demo.productservice.service;

import demo.productservice.dto.ProductResponseDto;
import demo.productservice.entity.Product;

public interface ProductService {
    ProductResponseDto getProductById(Long id);
    ProductResponseDto updateProduct(Long id, Product newProduct);
}
