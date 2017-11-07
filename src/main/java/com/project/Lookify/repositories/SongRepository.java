package com.project.Lookify.repositories;

import com.project.Lookify.models.Song;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository 												
public interface SongRepository extends CrudRepository<Song,Long>{
	// Query methods go here.
	List<Song> findAll();
	// List<Song> findByArtist(String search);
	List<Song> findTop10ByOrderByRatingDesc();
	// Example:
	// public YourModelHere findByName(String name);
}
