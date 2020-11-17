package com.tjmt.procs;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Optional;

import org.aspectj.lang.annotation.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tjmt.procs.api.controller.Tb_juizController;
import com.tjmt.procs.domain.dto.Tb_juizDTO;
import com.tjmt.procs.domain.repository.Tb_juizRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { Tb_juizController.class })
public class JuizEndPointTest {

	// URL base para acesso desse controlador
	private final String BASE_URL = "/produtos";

	// Instância do ObjectMapper para trabalhar com JSON
	private ObjectMapper objectMapper;

	// Controlador REST tratado por meio de injeção de dependências
	@Autowired
	private Tb_juizController restController;

	// Instância do MockMVC
	private MockMvc mockMvc;

	// Instância do mock repository
	@MockBean
	private Tb_juizRepository mockRepository;

	@Before(value = "")
	public void setUp() {
		objectMapper = new ObjectMapper();
		mockMvc = MockMvcBuilders.standaloneSetup(restController).build();
	}

	@Test
	public void buscar_id_200() throws Exception {

		Tb_juizDTO juiz= new Tb_juizDTO();
		juiz.setId(1L);
		juiz.setNome("Teste");
		juiz.setCpf("");

	//	when(mockRepository.findById(1L)).thenReturn(Optional.of(juiz));

		mockMvc.perform(get(BASE_URL + "/1")).andExpect((ResultMatcher) content().contentType(MediaType.APPLICATION_JSON_UTF8))
				.andExpect(status().isOk()).andExpect(jsonPath("$.id", is(1)))
				.andExpect(jsonPath("$.nome", is("Teste"))).andExpect(jsonPath("$.valor", is(10.0)));

		verify(mockRepository, times(1)).findById(1L);
	}

}
