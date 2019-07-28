package wcci.nflapi.Repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import wcci.nflapi.Entities.Team;

@Repository
public interface TeamRepository extends CrudRepository<Team, Long> {
	Team findByTeamName(String teamName);
	
}
