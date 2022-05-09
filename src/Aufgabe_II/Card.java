package Aufgabe_II;

import java.util.Objects;

public class Card {
	
	private final String name;
	private final int baseAttack;
	private final int baseDefense;
	private Category category;
	private int health;
	private Buff buff = null;
	
	public Card(String name,  int baseDefense, int baseAttack, Category category, int health) {
		if (name == null || name.equals(""))
			throw new IllegalArgumentException("Name darf nicht leer oder null sein.");
		else
			this.name = name;
		
		if (baseAttack < 0)
			throw new IllegalArgumentException("Basisangrifsswert muss mindestens 0 sein!");
		else
			this.baseAttack = baseAttack;
		
		if (baseDefense < 0)
			throw new IllegalArgumentException("Basisverteidigungsswert muss mindestens 0 sein!");
		else 
			this.baseDefense = baseDefense;
			
		if (health <= 0)
			throw new IllegalArgumentException("Already dead.");
		else
			this.health = health;
		if (category == null)
			throw new IllegalArgumentException("Category darf nicht null sein!");
		else
			this.category = category;
	}
	
	public String getName() {
		return name;
	}
	
	public int getBaseAttack() {
		return baseAttack;
	}
	
	public int getBaseDefense() {
		return baseDefense;
	}
	
	public int getHealth() {
		return health;
	}
	
	public Category getCategory() {
		return category;
	}
	
	public Buff getBuff() {
		return buff;
	}

	public void setBuff(Buff buff) {
		this.buff = buff;
	}

	public boolean isAlive() {
		return health > 0 ? true : false;
	}
	
	public int getAttack() {
		return buff == null ? baseAttack : (baseAttack + buff.getAttackBuff() < 0 ? 0 : baseAttack + buff.getAttackBuff());
	}
	
	public int getDefense() {
		return buff == null ? baseDefense : (baseDefense + buff.getDefenseBuff() < 0 ? 0 : baseDefense + buff.getDefenseBuff());
	}
	


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Card other = (Card) obj;
		return baseAttack == other.baseAttack && baseDefense == other.baseDefense && Objects.equals(buff, other.buff)
				&& category == other.category && health == other.health && Objects.equals(name, other.name);
	}

	public String toString() {
		String ausgabe = "Name: " + name + ", Basisverteidigungswert: " + baseDefense + ", Basisangriffswert: " + baseAttack + ", Kategorie: " + category + ", Health: " + health + ", Buff: " + buff;
		return ausgabe;
	}
	
	public void attack(Card otherCard) {
		if (otherCard == null)
			throw new IllegalArgumentException("otherCard darf nicht null sein");
		if (!isAlive())
			throw new IllegalArgumentException(name + " muss am Leben sein.");
		if (!otherCard.isAlive())
			throw new IllegalArgumentException(otherCard.getName() + " muss am Leben sein.");
		
		if (otherCard.getDefense() < getAttack()) 
			otherCard.health = otherCard.health - (getAttack() - otherCard.getDefense());
		else if (otherCard.getDefense() == getAttack())
			otherCard.health = otherCard.health - 1;
		
		if (otherCard.health < 0)
			otherCard.health = 0;
		
		
	}
		
	}
