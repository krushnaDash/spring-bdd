package com.test.springbdd;

import java.io.File;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
	
	Logger log=LoggerFactory.getLogger(this.getClass());

	@GetMapping("/getProduct")
	public ResponseEntity<Product> getProduct(){
		log.info("Called /getProduct");
		return ResponseEntity.ok(new Product("Test"));
	}
	/**
	 * This method is added just to test the persistent shared storage for Azure app service
	 * by creating some files
	 * @param fileName
	 * @return
	 * @throws Exception
	 */
	@GetMapping("/createFile/{fileName}")
	public ResponseEntity<String> createFile(@PathVariable String fileName)throws Exception{
		log.info("Called /createFile");
		File dir= new File("/home");
		dir.mkdirs();
		File file = new File(dir,fileName);
		
		boolean fileCreated=file.createNewFile();
		return ResponseEntity.ok("File Crated "+fileCreated +file.getAbsolutePath());
	}
	
	

}
