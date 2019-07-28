package wcci.nflapi.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import wcci.nflapi.Entities.Team;
import wcci.nflapi.Repositories.TeamRepository;

@RestController
@RequestMapping("/api")
public class TeamController {
	@Autowired
	TeamRepository teamRepo;

	@GetMapping("/teams")
	@CrossOrigin
	public Iterable<Team> sendTeams() {
		return teamRepo.findAll();
	}

	@GetMapping("/teams/{id}")
	@CrossOrigin
	public Team sendTeam(@PathVariable Long id) {
		return teamRepo.findById(id).get();
	}
}
