package com.itvedant.petstore.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.itvedant.petstore.services.FileUploadService;



@RestController
@RequestMapping("/files")
public class FileUploadController {

	@Autowired
	private FileUploadService uploadService;
	
	@PostMapping("/upload")
	public ResponseEntity<?> upload(@RequestParam("file") MultipartFile file){
		String filename = this.uploadService.storeFile(file);
		String fileUploadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
								.path("/files/download/")
								.path(filename)
								.toUriString();
		return new ResponseEntity<>(fileUploadUri,HttpStatus.OK);
	}
	
	@GetMapping("/download/{filename}")
	public ResponseEntity<?> download(@PathVariable String filename){
		Resource resource = this.uploadService.loadAsResource(filename);
		return ResponseEntity.ok()
				.header(HttpHeaders.CONTENT_DISPOSITION, 
						"attachment; filename=\"" + filename + "\"").body(resource);
	}
}

