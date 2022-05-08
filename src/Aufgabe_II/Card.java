package Aufgabe_II;

import java.util.Objects;

public class Card {

    public String Name;
    public int baseAttack;
    public int baseDefense;
    public int health;
    public Buff buff;
    public Category kategorie;

    /**
     * Konstruktor baut neue Card - inkl. check
     *
     * @param Name
     * @param baseDefense
     * @param baseAttack
     * @param kategorie
     * @param health
     */
    public Card(String Name, int baseDefense, int baseAttack, Category kategorie, int health) {
        if (Name == null) {
            throw new IllegalArgumentException("Es muss ein gültiger Name vergeben werden!");
        }
        else if (Name.isEmpty()) {
            throw new IllegalArgumentException("Es muss ein gültiger Name vergeben werden!");
        }
        else {
            this.Name=Name;
        }
        if (baseAttack < 0) {
            throw new IllegalArgumentException("Der Wert muss mindestens 0 sein!");
        }
        else {
            this.baseAttack=baseAttack;
        }
        if (baseDefense < 0) {
            throw new IllegalArgumentException("Der Wert muss mindestens 0 sein!");
        }
        else {
            this.baseDefense=baseDefense;
        }
        if (health <= 0) {
            throw new IllegalArgumentException("Der Wert muss mindestens 0 sein!");
        }
        else {
            this.health=health;
        }
        if (kategorie == null) {
            throw new IllegalArgumentException("Kategorie darf nicht null sein!");
        }
        else {
            this.kategorie=kategorie;
        }

        this.buff=null;
    }

    public String getName() {
        return Name;
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

    public Buff getBuff() {
        return buff;
    }

    public Category getCategory() {
        return kategorie;
    }

    public void setHealth(int health) {
        this.health=health;
    }

    // Buff set
    public void setBuff(Buff buff) {
        this.buff=buff;
        //this.baseAttack = baseAttack + buff.getAttackBuff();
        //this.baseDefense = baseDefense + buff.getDefenseBuff();
    }

    public boolean isAlive(){
        if(health>0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public int getAttack(){
        if(buff==null)
        {
            return baseAttack;
        } else if (buff!=null) {
            baseAttack+=buff.getAttackBuff();
            return baseAttack;
        }
        return baseAttack;
    }


    //getDefense
    public int getDefense() {
        if (buff == null) {
            return baseDefense;
        }
        else if (baseDefense + buff.getDefenseBuff()<=0) {
            return 0;
        }
        else {
            return baseDefense + buff.getDefenseBuff();
        }
    }

    /**
     * @param name
     * @param baseAttack
     * @param baseDefense
     * @param health
     * @param buff
     */
    public void toString(String name, int baseAttack, int baseDefense, int health, Buff buff)
    {
        System.out.printf("%s (A:%s, D:%s, H:%s)", name, baseAttack, baseDefense, health);
    }

    /**
     * @param otherCard
     */
    //Attack
    public void attack(Card otherCard) {
        if (otherCard == null) {
            throw new IllegalArgumentException("Es müssen zwei Karten angegeben werden!");
        }
        else if (this.isAlive() && otherCard.isAlive()) {
            if (this.getAttack()>otherCard.getDefense()) {
                if ((otherCard.getDefense()-this.getAttack())+otherCard.getHealth()<=0) {
                    otherCard.setHealth(0);
                }
                else {
                    otherCard.setHealth((otherCard.getDefense()-this.getAttack())+otherCard.getHealth());
                }
            }
            else if (this.getAttack()==otherCard.getDefense()) {
                otherCard.health=otherCard.health-1;
            }
        }
        else {
            throw new IllegalArgumentException("Beide Karten müssen am Leben sein!");
        }
    }

    @Override
    public boolean equals(Object obj)
    {
        if (this==obj)
        {
            return true;
        }
        if (obj==null)
        {
            return false;
        }
        if(getClass()!=obj.getClass())
        {
            return false;
        }
        Card otherObj = (Card)obj;

        if(Name.equals(otherObj.getName()) && baseDefense==otherObj.baseDefense && health==otherObj.health && baseAttack==otherObj.baseAttack && Objects.equals(buff, otherObj.buff) && kategorie==otherObj.kategorie)
        {
            return true;
        }
        return false;
    }
}
