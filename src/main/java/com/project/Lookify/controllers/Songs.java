package com.project.Lookify.controllers;

import java.security.Principal;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.project.Lookify.models.Song;
import com.project.Lookify.services.SongService;

@Controller
public class Songs{
	private final SongService songService;
	public Songs(SongService songService) {
		this.songService = songService;
	}
	
	@RequestMapping("")
	public String index(){
		return "index";
	}
	@RequestMapping("/dashboard")
	public String dash(Model model, @ModelAttribute("song") Song song) {
		List<Song> songs = songService.allSongs();
		model.addAttribute("songs", songs);
		return "dash";
	}	
	@RequestMapping("/songs/new")
	public String add(@ModelAttribute("song") Song song){
		return "new";
	}
	@PostMapping("/songs/new")
	public String addSong(@Valid @ModelAttribute("song") Song song, BindingResult result) {
		if(result.hasErrors()) {
			return "new";
		} else {
			songService.addSong(song);
			return "redirect:/dashboard";
		}
	}
	@RequestMapping("/songs/{id}")
	public String showSong(Model model, @PathVariable("id") Long id) {
		Song song = songService.findSongById(id);
		model.addAttribute("song", song);
		return "show";
	}
	@RequestMapping("/songs/delete/{id}")
	public String deleteSong(@PathVariable("id") Long id) {
		songService.deleteSong(id);
		return "redirect:/dashboard";
	}
	@RequestMapping("/search/topTen")
	public String topTen(Model model) {
		List<Song> songs = songService.topTen();
		model.addAttribute("songs", songs);
		return "top";
	} 	
}
