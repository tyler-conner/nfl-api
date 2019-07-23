package wcci.nflapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class TeamController {
	@Autowired
	TeamRepository teamRepo;

	@GetMapping("/teams")
	public Iterable<Team> sendTeams() {
		return teamRepo.findAll();
	}

	@GetMapping("/teams/{id}")
	public Team sendTeam(@PathVariable Long id) {
		return teamRepo.findById(id).get();
	}
}
