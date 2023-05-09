package com.itvedant.petstore.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.itvedant.petstore.dtos.AddProductDto;
import com.itvedant.petstore.dtos.UpdateProductDto;
import com.itvedant.petstore.services.ProductService;


//@CrossOrigin(origins = "http://localhost:5500", maxAge = 3600)
@RestController
@CrossOrigin(origins= {"*"}, maxAge = 4800, allowCredentials = "false" )
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @PostMapping("/{id}/upload")
	public ResponseEntity<?> upload(@RequestParam("file") MultipartFile file, 
            @PathVariable Integer id){		
        return ResponseEntity.ok(this.productService.storeFile(id, file));
	}
	
	@GetMapping("/download/{filename}")
	public ResponseEntity<?> download(@PathVariable String filename){
		Resource resource = this.productService.loadAsResource(filename);
		return ResponseEntity.ok()
				.header(HttpHeaders.CONTENT_DISPOSITION, 
						"attachment; filename=\"" + filename + "\"").body(resource);
	}

    // @PostMapping("")
    // public ResponseEntity<?> create(@RequestBody AddProductDto addProductDto){
    //     return ResponseEntity.ok(this.productService.createProduct(addProductDto));
    // }

    // @GetMapping("")
    // public ResponseEntity<?> getAll(){
    //     return ResponseEntity.ok(this.productService.getAllProducts());
    // }

    // @GetMapping("{id}")
    // public ResponseEntity<?> getById(@PathVariable("id") Integer id) {
	//     return ResponseEntity.ok(this.productService.getProductById(id));
    // }

    // @PutMapping("{id}")
    // public ResponseEntity<?> update(@PathVariable("id") Integer id,
	// 	@RequestBody UpdateProductDto updateProductDto) {
	// return ResponseEntity.ok(this.productService.updateProduct
    //             (id, updateProductDto));
    // }

    // @DeleteMapping("{id}")
    // public ResponseEntity<?> delete(@PathVariable("id") Integer id) {
    //     this.productService.deleteProduct(id);
    //     return ResponseEntity.noContent().build();
    // }

    // @GetMapping("/search/findbymanufacturer")
    // public ResponseEntity<?> getByManufacturer(@RequestParam String manufacturer){
    //     return ResponseEntity.ok(this.productService.getByManufacturer(manufacturer));
    // }

    // @GetMapping("/search/findbyprice")
    // public ResponseEntity<?> getByPrice(@RequestParam Double price){
    //     return ResponseEntity.ok(this.productService.getByPrice(price));
    // }

    // @GetMapping("/search/sortbyname")
    // public ResponseEntity<?> sortByName(){
    //     return ResponseEntity.ok(this.productService.sortByName());
    // }

}
