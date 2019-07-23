package wcci.nflapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class DivisionController {
	@Autowired
	DivisionRepository divisionRepo;

	@GetMapping("/divisions")
	public Iterable<Division> sendDivisions() {
		return divisionRepo.findAll();
	}

	@GetMapping("/divisions/{id}")
	public Division sendDivision(@PathVariable Long id) {
		return divisionRepo.findById(id).get();
	}
}
