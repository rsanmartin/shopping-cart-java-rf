package com.supercon.service.product.impl;

import org.springframework.stereotype.Service;

import com.supercon.model.product.AbstractProduct;
import com.supercon.model.product.Product;
import com.supercon.service.product.ProductServices;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServicesImpl implements ProductServices{

	private List<AbstractProduct> products;
	
	// Simple source of products: would come from a database in the real world.
    private static final List<AbstractProduct> ALL_PRODUCTS = Arrays.asList(
            new Product(24.99, "CHAIR_RED", "Red plastic chair"),
            new Product(24.99, "DIS_10-CHAIR_BLUE", "Blue plastic chair"),
            new Product(24.99, "CHAIR_WHITE", "White plastic chair"),
            new Product(14.99, "STOOL_WHITE", "White plastic footstool"),
            new Product(14.99, "DIS_15-STOOL_GREEN", "Green plastic footstool"),
            new Product(74.99, "COMP_DESK", "Wooden computer desk"),
            new Product(129.99, "COMP_CHAIR", "Computer swivel chair"),
            new Product(249.99, "BOARD_TABLE", "12-person boardroom table"),
            new Product(99.99, "BOARD_CHAIR", "Boardroom chair")
    );

    public ProductServicesImpl() {
        this.products = ALL_PRODUCTS;
    }

    public ProductServicesImpl(final List<AbstractProduct> products) {
        this.products = products;
    }

    public List<String> getProductCodes() {
        return products.stream()
                .map(AbstractProduct::getProductCode)
                .collect(Collectors.toList());
    }

    public AbstractProduct getProduct(final String code) {
        for (final AbstractProduct product : products) {
            if (product.getProductCode().equals(code)) {
                return product;
            }
        }
        return null;
    }

	@Override
	public List<AbstractProduct> getAllProducts() {
		// TODO Auto-generated method stub
		return ALL_PRODUCTS;
	}
}
