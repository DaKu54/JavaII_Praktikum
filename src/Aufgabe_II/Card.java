package Aufgabe_II;

public class Card {

    public static String Name;
    public static int baseAttack;
    public static int baseDefense;
    public static int health;
    public static Buff buff;
    public static Category kategorie;

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

    public static String getName() {
        return Name;
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

    public Category getCategory() {
        return kategorie;
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
        return false;
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
