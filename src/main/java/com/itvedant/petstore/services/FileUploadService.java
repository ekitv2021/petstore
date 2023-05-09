package com.itvedant.petstore.services;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.itvedant.petstore.FileStorageProperties;
import com.itvedant.petstore.exceptions.StorageException;

@Service
public class FileUploadService {
	
	private final Path rootLocation;
	
	@Autowired
	public FileUploadService(FileStorageProperties properties) {
		this.rootLocation = Paths.get(properties.getUploadDir());
		
		try {
			Files.createDirectories(rootLocation);
		} catch (IOException e) {
			throw new StorageException("Could not initialize directory");
		}
	}
	
	public String storeFile(MultipartFile file) {
		try {
			if(file.isEmpty()) {
				throw new StorageException("Could not store empty file");
			}
			
			Path destinationFile = this.rootLocation.resolve(
					Paths.get(file.getOriginalFilename()));
			
			try(InputStream inputStream = file.getInputStream()){
				Files.copy(inputStream, destinationFile, StandardCopyOption.REPLACE_EXISTING);
			}
			
			return file.getOriginalFilename();
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
}
