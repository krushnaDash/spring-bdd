package com.test.springbdd;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

	Logger log = LoggerFactory.getLogger(this.getClass());
	

	@Autowired
	Environment env;
	
	@GetMapping("/getProduct")
	public ResponseEntity<Product> getProduct() {
		log.info("Called /getProduct");
		return ResponseEntity.ok(new Product("Test"));
	}

	/**
	 * This method is added just to test the persistent shared storage for Azure app
	 * service by creating some files
	 * 
	 * @param fileName
	 * @return
	 * @throws Exception
	 */
	@GetMapping("/createFile/{fileName}")
	public ResponseEntity<Map<String, Object>> createFile(@PathVariable String fileName) throws Exception {
		log.info("Called /createFile");
		File dir = new File("/home");
		dir.mkdirs();
		File file = new File(dir, fileName);
		boolean fileCreated = file.createNewFile();
		Map<String, Object> data = new HashMap<>();
		data.put("files List", dir.listFiles());
		data.put("Message", "File Crated " + fileCreated + file.getAbsolutePath());
		data.put("FromKeyValue",env.getProperty("connectionString"));
		return ResponseEntity.ok(data);
	}

}
