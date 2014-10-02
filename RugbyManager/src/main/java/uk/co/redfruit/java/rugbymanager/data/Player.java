package uk.co.redfruit.java.rugbymanager.data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
public class Player {
	
	@Id @GeneratedValue
	private int id;
	
	private String name;
	
	private int skill;
	
	private int strength;
	
	private int handling;
	
	private int speed;
	
	private int kicking;
	
	private int tackling;
	
	private int mental;
	
	private int form;
	
	private int agility;
	
	private String position;

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

	public int getSkill() {
		return skill;
	}

	public void setSkill(int skill) {
		this.skill = skill;
	}

	public int getStrength() {
		return strength;
	}

	public void setStrength(int strength) {
		this.strength = strength;
	}

	public int getHandling() {
		return handling;
	}

	public void setHandling(int handling) {
		this.handling = handling;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public int getKicking() {
		return kicking;
	}

	public void setKicking(int kicking) {
		this.kicking = kicking;
	}

	public int getTackling() {
		return tackling;
	}

	public void setTackling(int tackling) {
		this.tackling = tackling;
	}

	public int getMental() {
		return mental;
	}

	public void setMental(int mental) {
		this.mental = mental;
	}

	public int getForm() {
		return form;
	}

	public void setForm(int form) {
		this.form = form;
	}

	public int getAgility() {
		return agility;
	}

	public void setAgility(int agility) {
		this.agility = agility;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}
	
	

}
