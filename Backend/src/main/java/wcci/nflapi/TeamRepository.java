package wcci.nflapi;

import org.springframework.data.repository.CrudRepository;

public interface TeamRepository extends CrudRepository<Team, Long> {
	Team findByName(String teamName);
	
}
