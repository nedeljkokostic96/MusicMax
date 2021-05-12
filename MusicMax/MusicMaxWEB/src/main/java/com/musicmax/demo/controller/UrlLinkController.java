package com.musicmax.demo.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.musicmax.demo.service.FileService;

@RestController
@RequestMapping(value = "/upload")
public class UrlLinkController {
	
	@Autowired
	private FileService fileService;

	@PostMapping(value = "/file", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public Map<String, Object> uploadFile(@RequestParam("file") MultipartFile file) {
		return fileService.uploadFile(file);
	}
	
}
