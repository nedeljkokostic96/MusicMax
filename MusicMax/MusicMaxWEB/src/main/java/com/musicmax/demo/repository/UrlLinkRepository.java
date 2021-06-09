package com.musicmax.demo.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import model.UrlLink;

public interface UrlLinkRepository extends JpaRepository<UrlLink, Integer> {

	@Query("SELECT u FROM UrlLink u WHERE u.song.idSong = :song")
	public UrlLink getResourceBySong(@Param("song") int song);

	@Query("SELECT u FROM UrlLink u WHERE u.funFact.idFunFact = :funFact")
	public UrlLink getResourceByFunFact(@Param("funFact") int funFact);

}
