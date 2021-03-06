package wcci.nflapi.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import wcci.nflapi.Entities.Division;
import wcci.nflapi.Repositories.DivisionRepository;

@RestController
@RequestMapping("/api")
public class DivisionController {
	@Autowired
	DivisionRepository divisionRepo;

	@GetMapping("/divisions")
	@CrossOrigin
	public Iterable<Division> sendDivisions() {
		return divisionRepo.findAll();
	}

	@GetMapping("/divisions/{id}")
	@CrossOrigin
	public Division sendDivision(@PathVariable Long id) {
		return divisionRepo.findById(id).get();
	}
}
