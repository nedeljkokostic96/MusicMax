package com.musicmax.demo.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import model.Creator;
import model.Song;

public interface SongRepository extends JpaRepository<Song, Integer> {

	@Query("select s from Song s join s.songHasGenres sHG where sHG.genre.idGenre = :idGenre")
	public List<Song> findByGenre(@Param("idGenre") Integer idGenre);

	@Query("select s from Song s where s.title = :songTitle")
	public List<Song> findByTitle(@Param("songTitle") String songTitle);

	@Query("SELECT s from Song s WHERE s.released BETWEEN :dateStart AND :dateEnd")
	public List<Song> findSongsByYear(@Param("dateStart") Date dateStart, @Param("dateEnd") Date dateEnd);

	@Query("select s from Song s where s.creator2 = :composer")
	public List<Song> findByComposer(@Param("composer") Creator composer);
}
