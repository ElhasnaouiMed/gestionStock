package com.app.gestionStock.dao;

import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.app.gestionStock.model.Collaborater;

/**
 * @author mohamed Test JUnit with @DataJpaTest
 *         https://www.baeldung.com/spring-boot-testing
 * @RunWith (SpringRunner.class) est utilisé pour fournir un pont entre les
 *          fonctionnalités de test Spring Boot et JUnit. Chaque fois que nous
 *          utilisons des fonctionnalités de test Spring Boot dans nos tests
 *          JUnit, cette annotation sera requise.
 *
 * @DataJpaTest fournit une configuration standard nécessaire pour tester la
 *              couche de persistance:
 *
 *              configuration de H2, une base de données en mémoire définition
 *              de Hibernate, Spring Data et DataSource effectuer un @EntityScan
 *              activation de la journalisation SQL
 */
@RunWith(SpringRunner.class)
@DataJpaTest
public class TestCollaboraterDao {

	@Autowired
	private TestEntityManager entityManager;

	@Autowired
	private ICollaboraterDao collaborater;

	/**
	 * Test d'intégration.
	 */
	@Test
	public void iCollaboraterDaoFindByRegisterNumber() {
		// given
		Collaborater coll = new Collaborater();
		coll.setBirthDate(LocalDate.now());
		coll.setCreationDate(LocalDate.now());
		coll.setEmail("hh@hh.com");
		coll.setFirstName("med");
		coll.setLastName("med");
		coll.setId(1);
		coll.setRegisteredNumber("aaaa");
		entityManager.merge(coll);
		entityManager.flush();

		// when
		Collaborater found = collaborater.findByRegisteredNumberIgnoreCase("aaaa");

		// then
		assertEquals(found.getFirstName(), coll.getFirstName());

	}
}
