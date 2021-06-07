package com.musicmax.demo.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.musicmax.demo.repository.UrlLinkRepository;

import model.UrlLink;

@Service
public class FileService {
	
	@Autowired
	private UrlLinkRepository urlLinkRepository;

	public final static String FILE_LOCATION = "D:/LocalServerStorage/";

	public ResponseEntity<?> uploadFile(MultipartFile file) {

		Map<String, Object> response = new HashMap<String, Object>();
		response.put("status", false);

		File convertFile = new File(FILE_LOCATION + file.getOriginalFilename());
		FileOutputStream fileOutputStream = null;
		try {
			convertFile.createNewFile();
			fileOutputStream = new FileOutputStream(convertFile);
			fileOutputStream.write(file.getBytes());
			response.put("status", saveFileLocation(FILE_LOCATION + file.getOriginalFilename()));
			return ResponseEntity.ok("File uploaded!");
		} catch (IOException e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().body("Error due uploading file!");
		} finally {
			if (fileOutputStream != null) {
				try {
					fileOutputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	private boolean saveFileLocation(String fileLocation) {
		UrlLink link = new UrlLink();
		link.setUrlResource(fileLocation);
		return urlLinkRepository.save(link) != null;
	}

}
