package com.stackroute.form.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.stackroute.form.dao.TrackDAO;
import com.stackroute.form.model.Track;

@Controller
@RequestMapping("/")
public class TrackController {

	@Autowired
	private TrackDAO trackDao;

	private Track track = new Track();

	@GetMapping
	public String indexPage(ModelMap model) {
		return "index";
	}

	@GetMapping("login")
	public String addTrack(@RequestParam("userName") String username,@RequestParam("password") String password, ModelMap model) {
			track.setName(username);
			track.setPassword(password);
			boolean status = trackDao.saveTrack(track);
			if (status) {
				model.addAttribute("message", trackDao.getTrackById(track.getId()));
				return "update";
			} else {
				return "index";
			}

		}

}

