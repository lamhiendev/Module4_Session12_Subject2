package demo.productservice.controller;

import demo.productservice.dto.ProductResponseDto;
import demo.productservice.entity.Product;
import demo.productservice.service.impl.ProductServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductServiceImpl productService;
    @GetMapping("/{id}")
    public ResponseEntity<ProductResponseDto> getProductById(@PathVariable Long id){
        ProductResponseDto productResponseDto = productService.getProductById(id);
        return new ResponseEntity<>(
                productResponseDto,
                HttpStatus.OK
        );
    }
    @PutMapping("/{id}")
    public ResponseEntity<ProductResponseDto> updateProductById(@PathVariable Long id, @RequestBody Product product){
        ProductResponseDto productResponseDto = productService.updateProduct(id,product);
        return new ResponseEntity<>(
                productResponseDto,
                HttpStatus.OK
        );
    }
}
