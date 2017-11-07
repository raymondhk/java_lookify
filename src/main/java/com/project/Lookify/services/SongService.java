package com.project.Lookify.services;

import java.util.ArrayList;
import java.util.List;

// import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.project.Lookify.models.Song;
import com.project.Lookify.repositories.SongRepository;

@Service
public class SongService {
	// Member variables / service initializations go here
	private SongRepository songRepository;
	public SongService(SongRepository songRepository) {
		this.songRepository = songRepository;
	}
	
	// Crud methods to act on services go here.
	public List<Song> allSongs() {
		return (List<Song>) songRepository.findAll();
	}
	public void addSong(Song song) {
		songRepository.save(song);
	}
	public Song findSongById(Long id) {
		return songRepository.findOne(id);
	}
	public void deleteSong(Long id) {
		songRepository.delete(id);
	}
	public List<Song> topTen() {
		return songRepository.findTop10ByOrderByRatingDesc();
	}
}
