package com.test.springbdd;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
	
	Logger log=LoggerFactory.getLogger(this.getClass());

	@GetMapping("/getProduct")
	public ResponseEntity<Product> getProduct(){
		log.info("Called /getProduct");
		return ResponseEntity.ok(new Product("Test"));
	}

}
