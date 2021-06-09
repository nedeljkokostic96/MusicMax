package com.musicmax.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.musicmax.demo.service.FileService;

@RestController
@RequestMapping(value = "/files")
public class UrlLinkController {
	
	@Autowired
	private FileService fileService;

	@PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> uploadFile(@RequestBody MultipartFile file, @RequestParam("id") int id, @RequestParam("song") boolean song){
		return fileService.uploadFile(file, id, song);
	}
	
}
