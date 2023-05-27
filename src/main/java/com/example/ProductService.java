package com.example;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service 
public class ProductService {
@Autowired
ProductRepository productRepository;

public List<Product> getDetails(){
	return productRepository.findAll();
}

public void saveData(Product product) {
	productRepository.save(product);
}

public void deleteProduct(Long id) {
	productRepository.deleteById(id);
}

public Product getProduct(Long id) {
	return productRepository.findById(id).get();
}
}
