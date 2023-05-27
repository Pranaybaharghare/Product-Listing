package com.example;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class TestController {

	@Autowired
	ProductService productService;
	
	@GetMapping("/")
	public String homePage(Model model) {
		List<Product> products = productService.getDetails();
		model.addAttribute("products",products);
		return "index";
	}
	
	@GetMapping("/new")
	public String newProduct(Model model) {
		model.addAttribute("product",new Product());
		return "new-product";
	}
	
	@PostMapping("/save")
	public String saveProduct(Product product) {
		productService.saveData(product);
 		return "redirect:/";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteProduct(@PathVariable Long id) {
		productService.deleteProduct(id);
		return "redirect:/";
	}
	
	
	@GetMapping("/edit/{id}")
	public String editProduct(@PathVariable Long id,Model model) {
		Product product = productService.getProduct(id);
		model.addAttribute(product);
		return "editproduct";
	}
}
