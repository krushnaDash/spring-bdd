package com.test.springbdd;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

	@GetMapping("/getProduct")
	public ResponseEntity<Product> getProduct(){
		return ResponseEntity.ok(new Product("Test"));
	}

}
