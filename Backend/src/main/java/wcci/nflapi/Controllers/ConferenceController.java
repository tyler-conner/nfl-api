package wcci.nflapi.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import wcci.nflapi.Entities.Conference;
import wcci.nflapi.Repositories.ConferenceRepository;

@RestController
@RequestMapping("/api")
public class ConferenceController {
	@Autowired
	ConferenceRepository conferenceRepo;

	@GetMapping("/conferences")
	@CrossOrigin
	public Iterable<Conference> sendConferences() {
		return conferenceRepo.findAll();
	}

	@GetMapping("/conferences/{id}")
	@CrossOrigin
	public Conference sendConference(@PathVariable Long id) {
		return conferenceRepo.findById(id).get();
	}
}
