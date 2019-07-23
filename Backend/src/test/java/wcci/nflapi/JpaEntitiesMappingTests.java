package wcci.nflapi;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import wcci.nflapi.Entities.Conference;
import wcci.nflapi.Entities.Division;
import wcci.nflapi.Entities.Team;
import wcci.nflapi.Repositories.ConferenceRepository;
import wcci.nflapi.Repositories.DivisionRepository;
import wcci.nflapi.Repositories.TeamRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class JpaEntitiesMappingTests {
	
	@Autowired
	TestEntityManager entityManager;
	
	@Autowired
	private ConferenceRepository conferenceRepo;
	@Autowired
	private DivisionRepository divisionRepo;
	@Autowired
	private TeamRepository teamRepo;
	
	Conference testConference;
	Division testDivision;
	Team testTeam;
	
	@Before
	public void setup() {
		testConference = new Conference("NFC", "URL");
		conferenceRepo.save(testConference);
		testDivision = new Division("Division Name", "division URL");
		divisionRepo.save(testDivision);
		testTeam = new Team("Team Name","string","","","");
		teamRepo.save(testTeam);
		flushAndClearEntityManager();
	}
	
	@Test
	public void shouldSaveAndLoadConference() {
		Conference retrievedConference = conferenceRepo.findById(testConference.getId()).get();
		assertThat(retrievedConference, is(testConference));
	}
	@Test
	public void shouldSaveAndLoadDivision() {
		Division retrievedDivision = divisionRepo.findById(testDivision.getId()).get();
		assertThat(retrievedDivision, is(testDivision));
	}
	@Test
	public void shouldSaveAndLoadTeam() {
		Team retrievedTeam = teamRepo.findById(testTeam.getId()).get();
		assertThat(retrievedTeam, is(testTeam));
	}
	private void flushAndClearEntityManager() {
		entityManager.flush();
		entityManager.clear();
	}

}
