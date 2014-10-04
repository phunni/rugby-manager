package uk.co.redfruit.java.rugbymanager.tests;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.junit.After;
import org.junit.AfterClass;
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
	public void testPlayer() {
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
	
	@AfterClass
	public static void closeManager() {
		manager.close();
	}
}
