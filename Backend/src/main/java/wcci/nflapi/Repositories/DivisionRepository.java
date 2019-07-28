package wcci.nflapi.Repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import wcci.nflapi.Entities.Division;

@Repository
public interface DivisionRepository extends CrudRepository<Division, Long> {
	Division findByDivisionName(final String divisionName);
}
