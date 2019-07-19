package wcci.nflapi;

import org.springframework.data.repository.CrudRepository;

public interface DivisionRepository extends CrudRepository<Division, Long> {
	Division findByName(String divisionName);
}
