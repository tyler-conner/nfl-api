package wcci.nflapi.Repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import wcci.nflapi.Entities.Conference;

@Repository
public interface ConferenceRepository extends CrudRepository<Conference, Long> {
	Conference findByConferenceName(String conferenceName);
}
