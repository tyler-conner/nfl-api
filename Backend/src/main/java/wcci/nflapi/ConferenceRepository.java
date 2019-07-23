package wcci.nflapi;

import org.springframework.data.repository.CrudRepository;

public interface ConferenceRepository extends CrudRepository<Conference, Long> {
	Conference findByName(String conferenceName);
}
