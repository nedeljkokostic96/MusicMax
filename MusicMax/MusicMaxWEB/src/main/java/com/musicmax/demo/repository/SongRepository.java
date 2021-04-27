package com.musicmax.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import model.Song;

public interface SongRepository extends JpaRepository<Song, Integer> {

}
