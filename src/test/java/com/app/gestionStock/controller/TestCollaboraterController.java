package com.app.gestionStock.controller;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;


import static org.junit.Assert.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.hamcrest.CoreMatchers;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;

/**
 * @author mohamed
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class TestCollaboraterController {
	 @Autowired
	 private WebApplicationContext context;
	
	@Autowired
	private CollaboraterController collab;

	private MockMvc mockMvc;

	@Before
	public void stUp() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.context).build();
	}

	@Test
	public void contextLoads() {
		assertNotNull(collab);
	}

	@Test
	public void testStatus() throws Exception {
		this.mockMvc.perform(get("/home")).andExpect(status().isOk());
	}

	@Test
	public void testViewHome() throws Exception {
		this.mockMvc.perform(get("/")).andExpect(status().isOk()).andExpect(view().name("home"));
	}

	@Test
	public void testContent() throws Exception {
		this.mockMvc.perform(get("/")).andExpect(status().isOk()).andExpect(content().string(CoreMatchers.containsString("<h3>Historique des livraisons des masques :</h3>") 
	));
	}

	@Test
	public void testModelExist() throws Exception {
		this.mockMvc.perform(get("/home")).andExpect(status().isOk()).andExpect(model().attributeExists("deliveries"));
	}

	@After
	public void downUp() {
		this.mockMvc = null;
	}
}
