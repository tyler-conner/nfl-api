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

@WebMvcTest(DivisionController.class)
@RunWith(SpringRunner.class)
public class DivisionWebLayerTest {
	@Autowired
	MockMvc mockMvc;
	
	@MockBean
	DivisionRepository divisionRepo;

	private Division testDivision;
	
	private ObjectMapper mapper = new ObjectMapper();
	
	@Before 
	public void setup() {
		testDivision = new Division("divisionName", "imgUrl");
	}
	
	@Test
	public void fetchCollectionOfAllDivisions() throws Exception {
		when(divisionRepo.findAll()).thenReturn(Collections.singletonList(testDivision));
		mockMvc.perform(get("/api/divisions")).andDo(print()).andExpect(status().isOk())
		.andExpect(content().contentType("application/json;charset=UTF-8"))
		.andExpect(content().json(mapper.writeValueAsString(Collections.singletonList(testDivision)),true));
	}
	
	@Test
	public void fetchSingleDivision()  throws Exception {
		when(divisionRepo.findById(1L)).thenReturn(Optional.of(testDivision));
		mockMvc.perform(get("/api/divisions/1")).andDo(print()).andExpect(status().isOk())
		.andExpect(content().contentType("application/json;charset=UTF-8"))
		.andExpect(content().json(mapper.writeValueAsString(testDivision), true));
	}
	
	
	
}
