package wcci.nflapi;

import java.util.Collections;
import java.util.Optional;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(TeamController.class)
@RunWith(SpringRunner.class)
public class TeamWebLayerTest {
	@Autowired
	MockMvc mockMvc;
	
	@MockBean
	TeamRepository teamRepo;

	private Team testTeam;

	private ObjectMapper mapper = new ObjectMapper();
	
	@Before 
	public void setup() {
		testTeam = new Team("teamName", "imgUrl", "coachName", "mascot", "0-0");
	}
	
	@Test
	public void fetchCollectionOfAllTeams() throws Exception {
		when(teamRepo.findAll()).thenReturn(Collections.singletonList(testTeam));
		mockMvc.perform(get("/api/teams")).andDo(print()).andExpect(status().isOk())
		.andExpect(content().contentType("application/json;charset=UTF-8"))
		.andExpect(content().json(mapper.writeValueAsString(Collections.singletonList(testTeam)),true));
	}
	
	@Test
	public void fetchSingleTeam()  throws Exception {
		when(teamRepo.findById(1L)).thenReturn(Optional.of(testTeam));
		mockMvc.perform(get("/api/teams/1")).andDo(print()).andExpect(status().isOk())
		.andExpect(content().contentType("application/json;charset=UTF-8"))
		.andExpect(content().json(mapper.writeValueAsString(testTeam), true));
	}
	
	
	
}
