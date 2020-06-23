package com.app.gestionStock.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import com.app.gestionStock.dao.ICollaboraterDao;
import com.app.gestionStock.model.Collaborater;

/**
 * @author mohamed
 * Mocking with @MockBean
 * https://www.baeldung.com/spring-boot-testing
 *
 */
@RunWith(SpringRunner.class)
public class TestICollaboraterService {

	@TestConfiguration
	static class CollaboraterServiceImplTestContextConfiguration {

		@Bean
		public ICollaboraterService collaboraterService() {
			return new CollaboraterServiceImpl();
		}
	}

	@Autowired
	private ICollaboraterService collaboraterService;

	@MockBean
	private ICollaboraterDao collaboraterRepository;

	@Before
	public void setUp() {
		Collaborater coll = new Collaborater();
		coll.setBirthDate(LocalDate.now());
		coll.setCreationDate(LocalDate.now());
		coll.setEmail("hh@hh.com");
		coll.setFirstName("med");
		coll.setLastName("med");
		coll.setId(1);
		coll.setRegisteredNumber("aaaa");
		Mockito.when(collaboraterRepository.findByRegisteredNumberIgnoreCase(coll.getRegisteredNumber()))
				.thenReturn(coll);
	}

	@Test
	public void whenValidName_thenCollaboratterShouldBeFound() {
		String name = "aaaa";
		Collaborater found = collaboraterService.findCollaboraterByRegisteredNumber(name);
		assertEquals(found.getRegisteredNumber(), name);
	}
}
