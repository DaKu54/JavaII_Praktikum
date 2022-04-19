package Aufgabe_II;

public class Card {

    public static String name;
    public static int baseAttack;
    public static int baseDefense;
    public static int health;
    public static Buff buff;

    public Card(String name, int baseAttack, int baseDefense, int health, Buff buff){
        if(name == null || name == "")
        {
            throw new IllegalArgumentException("name darf nicht null oder leer sein");
        } else if (baseAttack < 0 )
        {
            throw new IllegalArgumentException("baseAttack muss mindestens 0 sein");
        } else if (baseDefense < 0 )
        {
            throw new IllegalArgumentException("baseDefense muss mindestens 0 sein");
        }
    }

    public static String getName() {
        return name;
    }

    public static int getBaseAttack() {
        return baseAttack;
    }

    public static int getBaseDefense() {
        return baseDefense;
    }

    public static int getHealth() {
        return health;
    }

    public static Buff getBuff() {
        return buff;
    }

    public boolean isAlive(){
        if(health>0)
        {
            return true;
        }
        return false;
    }

    //TODO: Sollte buff null sein, geben Sie baseAttack/Defense unverändert zurück. Sollte buff nicht null sein, so wird buff.getAttackBuff()/.getDefenseBuff() auf baseAttack/baseDefense hinzuaddiert. Sollte nach der Addition ein negativer Wert herauskommen, geben Sie 0 zurück.
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

    public void toString(String name, int baseAttack, int baseDefense, int health, Buff buff)
    {
        System.out.printf("%s (A:%s, D:%s, H:%s)", name, baseAttack, baseDefense, health);
    }

    public void attack(Card otherCard){
        if(otherCard==null)
        {
            throw new IllegalArgumentException("otherCard darf nicht null sein");
        } else if (this.isAlive()==false || otherCard.isAlive()==false) {
            throw new IllegalArgumentException("Beide Karten müssen am Leben sein");
        }
    }

    public boolean equals(Card otherCard)
    {
        if(this == otherCard)
        {
            return true;
        }
        return false;
    }
}
