package com.supercon.controller.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.supercon.model.product.AbstractProduct;
import com.supercon.service.product.ProductServices;

/**
 * @author rosanmartin
 *
 */
@RestController
public class ProductController {

    @Autowired
    private ProductServices productService;

    @GetMapping("/v1/products")
    public List<String> getProducts() {
        return productService.getProductCodes();
    }

    @GetMapping("/v1/products/{code}")
    public ResponseEntity<AbstractProduct> getProduct(@PathVariable String code) {
        final AbstractProduct product = productService.getProduct(code);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

}
