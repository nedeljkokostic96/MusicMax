package com.musicmax.demo.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.musicmax.demo.message.request.SongForm;
import com.musicmax.demo.message.response.BestGradedSongWrapper;
import com.musicmax.demo.repository.CreatorRepository;
import com.musicmax.demo.repository.GradeRepository;
import com.musicmax.demo.repository.PerformerRepository;
import com.musicmax.demo.repository.SongRepository;
import com.musicmax.demo.util.Constants;
import com.musicmax.demo.util.DateConverter;

import model.Client;
import model.Creator;
import model.Grade;
import model.Performer;
import model.Song;

@Service
public class SongService {

	@Autowired
	private SongRepository songRepository;

	@Autowired
	private CreatorRepository creatorRepository;

	@Autowired
	private PerformerRepository performerRepository;

	@Autowired
	private ClientParserService clientParserService;

	@Autowired
	private GradeRepository gradeRepository;

	public List<Song> getSongsByGenre(@RequestParam(value = "idGenreSTR") String idGenreSTR) {
		Integer idGenre;
		try {
			idGenre = Integer.parseInt(idGenreSTR);
		} catch (NumberFormatException e) {
			return null;
		}
		return songRepository.findByGenre(idGenre);
	}

	public List<Song> getSongsByYear(@RequestParam(value = "year") String year) {
		Date dateStart = DateConverter
				.parseDate(year + Constants.DATE_SEPARATOR + "01" + Constants.DATE_SEPARATOR + "01");
		Date dateEnd = DateConverter
				.parseDate(year + Constants.DATE_SEPARATOR + "12" + Constants.DATE_SEPARATOR + "31");
		return songRepository.findSongsByYear(dateStart, dateEnd);
	}

	public List<Song> getSongsByComposer(@RequestParam(value = "composerID") String composerID) {
		Creator composer = creatorRepository.findById(Integer.parseInt(composerID)).get();
		return songRepository.findByComposer(composer);
	}

	public List<Song> getSongsByAuthor(@RequestParam(value = "authorID") String authorID) {
		Creator author = creatorRepository.findById(Integer.parseInt(authorID)).get();
		return songRepository.findByAuthor(author);
	}

	public List<Song> getSongsByPerformer(@RequestParam(value = "performerID") String performerID) {
		Performer performer = performerRepository.findById(Integer.parseInt(performerID)).get();
		return songRepository.findByPerformer(performer);
	}

	public ResponseEntity<?> saveSong(SongForm data, HttpServletRequest request) {

		Client client = clientParserService.parseClientFromJWT(request);

		Date releasedDate = DateConverter.parseDate(data.getDate());

		Creator author = creatorRepository.findById(data.getIdAuthor()).get();
		Creator composer = creatorRepository.findById(data.getIdComposer()).get();
		Performer perfomer = performerRepository.findById(data.getIdPerformer()).get();

		Song newSong = new Song();
		newSong.setClient(client);
		newSong.setCreator1(author);
		newSong.setCreator2(composer);
		newSong.setPerformer(perfomer);
		newSong.setReleased(releasedDate);
		newSong.setTitle(data.getTitle());
		newSong.setTextSong(data.getText());

		Song saved = songRepository.save(newSong);

		return saved != null ? ResponseEntity.ok("Added new song!")
				: ResponseEntity.badRequest().body("Adding new song failed!");
	}

	public ResponseEntity<?> getBestGradedSongLastMonth() {

		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.MONTH, -1);
		Date dateBeforeOneMonth = cal.getTime();

		List<Grade> grades = gradeRepository.findAll().stream()
				.filter(x -> x.getDate().compareTo(dateBeforeOneMonth) > 0).collect(Collectors.toList());

		Map<Integer, List<Grade>> mappedGrades = new HashMap<Integer, List<Grade>>();

		for (Grade grade : grades) {
			if (!mappedGrades.containsKey(grade.getSong().getIdSong())) {
				mappedGrades.put(grade.getSong().getIdSong(), new ArrayList<Grade>());
			}
			mappedGrades.get(grade.getSong().getIdSong()).add(grade);
		}

		Song bestSong = null;
		double bestGrade = 0.0;

		for (Entry<Integer, List<Grade>> entry : mappedGrades.entrySet()) {
			double tempSumOfGrades = 0.0;
			for (Grade grade : entry.getValue()) {
				tempSumOfGrades += grade.getGrade();
			}
			double tempBestGrade = tempSumOfGrades / entry.getValue().size();
			if (bestGrade < tempBestGrade) {
				bestGrade = tempBestGrade;
				bestSong = entry.getValue().get(0).getSong();
			}
		}

		BestGradedSongWrapper bestGradedSong = new BestGradedSongWrapper();
		bestGradedSong.setGrade(bestGrade);
		bestGradedSong.setSong(bestSong);

		return ResponseEntity.ok(bestGradedSong);
	}

	public ResponseEntity<?> getSongsByComposerName(String composer) {
		List<Song> response = songRepository.getSongsByComposerName(composer);
		return ResponseEntity.ok(response);
	}

	public ResponseEntity<?> getSongsByAuthorName(String author) {
		List<Song> response = songRepository.getSongsByAuthorName(author);
		return ResponseEntity.ok(response);
	}

	public ResponseEntity<?> getSongsByPerformerName(String performer) {
		List<Song> response = songRepository.getSongsByPerfomerName(performer);
		return ResponseEntity.ok(response);
	}

}
