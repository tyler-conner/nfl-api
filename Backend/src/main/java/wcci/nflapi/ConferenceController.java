package wcci.nflapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ConferenceController {
	@Autowired
	ConferenceRepository conferenceRepo;

	@GetMapping("/conferences")
	public Iterable<Conference> sendConferences() {
		return conferenceRepo.findAll();
	}

	@GetMapping("/conferences/{id}")
	public Conference sendConference(@PathVariable Long id) {
		return conferenceRepo.findById(id).get();
	}
}
