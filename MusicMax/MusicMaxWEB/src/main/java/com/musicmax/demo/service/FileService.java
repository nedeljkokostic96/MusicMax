package com.musicmax.demo.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.musicmax.demo.repository.FunFactRepository;
import com.musicmax.demo.repository.SongRepository;
import com.musicmax.demo.repository.UrlLinkRepository;

import model.FunFact;
import model.Song;
import model.UrlLink;

@Service
public class FileService {

	@Autowired
	private UrlLinkRepository urlLinkRepository;

	@Autowired
	private SongRepository songRepository;

	@Autowired
	private FunFactRepository funFactRepository;

	public final static String FILE_LOCATION = "D:/LocalServerStorage/";

	public ResponseEntity<?> uploadFile(MultipartFile file, int id, boolean song) {

		File convertFile = new File(FILE_LOCATION + file.getOriginalFilename());
		FileOutputStream fileOutputStream = null;
		try {
			convertFile.createNewFile();
			fileOutputStream = new FileOutputStream(convertFile);
			fileOutputStream.write(file.getBytes());
			boolean uploaded = saveFileLocation(FILE_LOCATION + file.getOriginalFilename(), id,
					song);
			return ResponseEntity.ok("status : " + uploaded);
		} catch (IOException e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().body("status" + false);
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

	private boolean saveFileLocation(String fileLocation, int id, boolean isSong) {
		UrlLink link = new UrlLink();
		link.setUrlResource(fileLocation);
		Song song = null;
		FunFact funFact = null;
		if (isSong) {
			song = songRepository.findById(id).get();
		} else {
			funFact = funFactRepository.findById(id).get();
		}
		link.setSong(song);
		link.setFunFact(funFact);
		return urlLinkRepository.save(link) != null;
	}

}
