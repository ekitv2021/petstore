package com.itvedant.petstore.services;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.itvedant.petstore.FileStorageProperties;
import com.itvedant.petstore.dtos.AddProductDto;
import com.itvedant.petstore.dtos.UpdateProductDto;
import com.itvedant.petstore.entities.Product;
import com.itvedant.petstore.exceptions.StorageException;
import com.itvedant.petstore.repositories.ProductRepository;

@Service
public class ProductService {    
    @Autowired
    private ProductRepository productRepository;

    private final Path rootLocation;

    public ProductService(FileStorageProperties properties) {
		this.rootLocation = Paths.get(properties.getUploadDir());		
		try {
			Files.createDirectories(rootLocation);
		} catch (IOException e) {
			throw new StorageException("Could not initialize directory");
		}
	}
	
	public String storeFile(Integer id, MultipartFile file) {
		try {
			if(file.isEmpty()) {
				throw new StorageException("Could not store empty file");
			}			
			Path destinationFile = this.rootLocation.resolve(Paths.get(file.getOriginalFilename()));			
			try(InputStream inputStream = file.getInputStream()){
				Files.copy(inputStream, destinationFile, StandardCopyOption.REPLACE_EXISTING);
			}
            Product product = this.productRepository.findById(id).orElseThrow(() ->{
                                throw new StorageException("Product with id " + id + 
                                        " does not exists");});                
            String fileUploadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
								.path("/products/download/")
                                .path(file.getOriginalFilename())
								.toUriString();
            product.setImageUrl(fileUploadUri);
            this.productRepository.save(product);	
            return "File Uploaded Successfully";
		}catch (IOException e) {
			throw new StorageException("Could not store file");
		}
	}
	
	public Resource loadAsResource(String fileName) {
		Path file = rootLocation.resolve(fileName);
		try {
			Resource resource = new UrlResource(file.toUri());
			
			if(resource.exists() || resource.isReadable()) {
				return resource;
			}
			else {
				throw new StorageException("Could not read file");
			}
		} catch (MalformedURLException e) {
			throw new StorageException("Could not read file");
		}
	}	

    // public List<Product> getByManufacturer(String manufacturer){
    //     return this.productRepository.findByManufacturer(manufacturer);
    // }

    // public List<Product> getByPrice(Double price){
    //     return this.productRepository.findByPriceLessThan(price);
    // }

    public List<Product> sortByName(){
        return this.productRepository.sortByName();
    }

    // public Product createProduct(AddProductDto addProductDto){
    //     Product product = new Product();
    //     product.setProductName(addProductDto.getProductName());
    //     product.setManufacturingDate(addProductDto.getManufacturingDate());
    //     product.setManufacturer(addProductDto.getManufacturer());
    //     product.setPrice(addProductDto.getPrice());
    //     product.setDescription(addProductDto.getDescription());
    //     product.setImageUrl(addProductDto.getImageUrl());
    //     productRepository.save(product);
    //     return product;
    // }

    // public Iterable<Product> getAllProducts(){
    //     return this.productRepository.findAll();
    // }

    // public Product getProductById(Integer id) {
    //     Product product = this.productRepository.findById(id).orElseGet(null);
    //     if (product == null) {
    //         throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Product not found");
    //     }
    //     return product;
    // }    

    // public void deleteProduct(Integer id) {
    //     Product product = this.getProductById(id);
    //     if (product == null) {
    //         throw new ResponseStatusException(HttpStatus.NOT_FOUND, 
    //                 "Product not found");
    //     }            
    //     this.productRepository.deleteById(id);;
    // }

    // public Product updateProduct(Integer id, UpdateProductDto updateProductDto) {
    //     Product product = getProductById(id);
    //     if (updateProductDto.getProductName() != null) {
    //         product.setProductName(updateProductDto.getProductName());
    //     }
    //     if (updateProductDto.getDescription() != null) {
    //         product.setDescription(updateProductDto.getDescription());
    //     }
    //     if (updateProductDto.getManufacturer() != null) {
    //         product.setManufacturer(updateProductDto.getManufacturer());
    //     }
    //     if (updateProductDto.getManufacturingDate() != null) {
    //         product.setManufacturingDate(updateProductDto.getManufacturingDate());
    //     }
    //     if (updateProductDto.getPrice() != null) {
    //         product.setPrice(updateProductDto.getPrice());
    //     }
    //     if (updateProductDto.getImageUrl() != null) {
    //         product.setImageUrl(updateProductDto.getImageUrl());
    //     }
    //     return this.productRepository.save(product);
    // }        
}
