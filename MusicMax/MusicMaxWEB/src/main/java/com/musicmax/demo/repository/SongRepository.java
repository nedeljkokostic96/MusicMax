package com.musicmax.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import model.Song;

public interface SongRepository extends JpaRepository<Song, Integer> {

	@Query("select s from Song s join s.songHasGenres sHG where sHG.genre.idGenre = :idGenre")
	public List<Song> findByGenre(@Param("idGenre") Integer idGenre);
	
}
