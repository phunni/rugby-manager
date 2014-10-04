package uk.co.redfruit.java.rugbymanager.data;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class Club {
	
	@Id @GeneratedValue
	private int id;
	
	private String name;
	
	private String shortName;
	
	private String chairman;
	
	private double funds;
	
	private String stadium;
	
	@OneToMany(cascade = CascadeType.ALL)
	private Set<Player> squad;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getShortName() {
		return shortName;
	}

	public void setShortName(String shortName) {
		this.shortName = shortName;
	}

	public String getChairman() {
		return chairman;
	}

	public void setChairman(String chairman) {
		this.chairman = chairman;
	}

	public double getFunds() {
		return funds;
	}

	public void setFunds(double funds) {
		this.funds = funds;
	}

	public String getStadium() {
		return stadium;
	}

	public void setStadium(String stadium) {
		this.stadium = stadium;
	}

	public Set<Player> getSquad() {
		return squad;
	}

	public void setSquad(Set<Player> squad) {
		this.squad = squad;
	}
	
	

}
