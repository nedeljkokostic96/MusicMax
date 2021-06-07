package com.musicmax.demo.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.musicmax.demo.message.request.FestivalCommentForm;
import com.musicmax.demo.repository.FestivalCommentRepository;
import com.musicmax.demo.repository.FestivalRepository;

import model.Client;
import model.Festival;
import model.FestivalComment;

@Service
public class FestivalCommentService {

	@Autowired
	private FestivalCommentRepository festivalCommentRepository;

	@Autowired
	private FestivalRepository festivalRepository;

	@Autowired
	private ClientParserService clientParserService;

	public ResponseEntity<?> saveFestivalComment(FestivalCommentForm data, HttpServletRequest request) {
		Client client = clientParserService.parseClientFromJWT(request);
		Festival festival = festivalRepository.findById(data.getIdFestival()).get();
		FestivalComment newFestivalComment = new FestivalComment();
		newFestivalComment.setClient(client);
		newFestivalComment.setFestival(festival);
		newFestivalComment.setText(data.getText());

		FestivalComment saved = festivalCommentRepository.save(newFestivalComment);
		return saved != null ? ResponseEntity.ok("Added new comment for festival!")
				: ResponseEntity.badRequest().body("Adding new comment for festival failed!");
	}
}
