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

import wcci.nflapi.Controllers.ConferenceController;
import wcci.nflapi.Entities.Conference;
import wcci.nflapi.Repositories.ConferenceRepository;

@WebMvcTest(ConferenceController.class)
@RunWith(SpringRunner.class)
public class ConferenceWebLayerTest {
	@Autowired
	MockMvc mockMvc;
	
	@MockBean
	ConferenceRepository conferenceRepo;

	private Conference testConference;

	private ObjectMapper mapper = new ObjectMapper();
	
	@Before 
	public void setup() {
		testConference = new Conference("conferenceName", "imgUrl");
	}
	
	@Test
	public void fetchCollectionOfAllConferences() throws Exception {
		when(conferenceRepo.findAll()).thenReturn(Collections.singletonList(testConference));
		mockMvc.perform(get("/api/conferences")).andDo(print()).andExpect(status().isOk())
		.andExpect(content().contentType("application/json;charset=UTF-8"))
		.andExpect(content().json(mapper.writeValueAsString(Collections.singletonList(testConference)),true));
	}
	
	@Test
	public void fetchSingleConference()  throws Exception {
		when(conferenceRepo.findById(1L)).thenReturn(Optional.of(testConference));
		mockMvc.perform(get("/api/conferences/1")).andDo(print()).andExpect(status().isOk())
		.andExpect(content().contentType("application/json;charset=UTF-8"))
		.andExpect(content().json(mapper.writeValueAsString(testConference), true));
	}
	
	
	
}
