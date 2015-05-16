package uk.co.redfruit.java.rugbymanager.data.tests;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.HashSet;
import java.util.Set;

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

import uk.co.redfruit.java.rugbymanager.data.Club;
import uk.co.redfruit.java.rugbymanager.data.Player;

public class ClubTest {
	
	private static EntityManager manager;

	@BeforeClass
	public static void initialiseManager() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("rugby-manager");
		manager = factory.createEntityManager();

	}

	@AfterClass
	public static void closeManager() {
		manager.close();
	}

	@Before
	public void setUpTestData() {
		Club testClub = new Club();
		testClub.setName("Test Club");
		Player testPlayer = new Player();
		testPlayer.setName("test-player");
		Set<Player> squad = new HashSet<Player>();
		squad.add(testPlayer);
		testClub.setSquad(squad);
		testPlayer.setClub(testClub);
		EntityTransaction testTransaction = manager.getTransaction();
		testTransaction.begin();
		manager.persist(testClub);
		testTransaction.commit();
	}

	@After
	public void deletetestData() {
		Query deleteClubQuery = manager.createQuery("delete from Club c where c.name = 'Test Club'");
		Query deletePlayerQuery = manager.createQuery("delete from Player p where p.name='test-player'");
		EntityTransaction deleteTransaction = manager.getTransaction();
		deleteTransaction.begin();
		deleteClubQuery.executeUpdate();
		deletePlayerQuery.executeUpdate();
		deleteTransaction.commit();
	}

	@Test
	public void testClub() {
		Club testClub = manager.createQuery("select c from Club c where c.name='Test Club'", Club.class).getSingleResult();
		assertNotNull(testClub);
		assertTrue("Test Club".equals(testClub.getName()));
		assertTrue(testClub.getSquad().size() == 1);
		Player testPlayer = testClub.getSquad().toArray(new Player[1])[0];
		assertNotNull(testPlayer);
		assertTrue("test-player".equals(testPlayer.getName()));
	}

}
