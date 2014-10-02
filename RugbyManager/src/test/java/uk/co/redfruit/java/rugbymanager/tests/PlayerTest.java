package uk.co.redfruit.java.rugbymanager.tests;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.Statement;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.eclipse.persistence.sessions.Session;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import uk.co.redfruit.java.rugbymanager.data.Player;

public class PlayerTest {
	
	private static EntityManager manager;
	
	@BeforeClass
	public static void initialiseManager() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("rugby-manager");
		manager = factory.createEntityManager();
	}

	@Before
	public void setUpTestData(){
		Player testPlayer = new Player();
		testPlayer.setName("test-player");
		testPlayer.setSkill(20);
		EntityTransaction testTransaction = manager.getTransaction();
		testTransaction.begin();
		manager.persist(testPlayer);
		testTransaction.commit();
	}
	
	@Test
	public void test() {
		Player testPlayer = (Player) manager.createQuery("select p from Player p where p.name='test-player'", Player.class).getSingleResult();
		assertNotNull(testPlayer);
		assertTrue("test-player".equals(testPlayer.getName()));
		assertTrue(testPlayer.getSkill() == 20);
	}

	@After
	public void destroyTestData(){
		Query deleteQuery = manager.createQuery("delete from Player p where p.name='test-player'");
		EntityTransaction deleteTransaction = manager.getTransaction();
		deleteTransaction.begin();
		deleteQuery.executeUpdate();
		deleteTransaction.commit();
	}
}
