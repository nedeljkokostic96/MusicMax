package com.musicmax.demo.service;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.musicmax.demo.message.request.GradeForm;
import com.musicmax.demo.repository.GradeRepository;
import com.musicmax.demo.repository.SongRepository;

import model.Client;
import model.Grade;
import model.Song;

@Service
public class GradeService {

	@Autowired
	private GradeRepository gradeRepository;

	@Autowired
	private SongRepository songRepository;

	@Autowired
	private ClientParserService clientParserService;

	public ResponseEntity<?> saveGrade(GradeForm data, HttpServletRequest request) {
		Song song = songRepository.findById(data.getIdSong()).get();
		Client client = clientParserService.parseClientFromJWT(request);

		Grade newGrade = new Grade();
		newGrade.setGrade(data.getGrade());
		newGrade.setDate(new Date());
		newGrade.setClient(client);
		newGrade.setSong(song);
		Grade saved = gradeRepository.save(newGrade);
		return new ResponseEntity<String>(saved != null ? HttpStatus.OK : HttpStatus.BAD_REQUEST);
	}

}
