package Aufgabe_II;

public class Buff {

    public static String Name;
    public static int defenseBuff;
    public static int attackBuff;

    public Buff(String Name, int defenseBuff, int attackBuff)
    {
        if (Name == null) {
            throw new IllegalArgumentException("Es muss ein gültiger Name vergeben werden!");
        }
        else if (Name.isEmpty()) {
            throw new IllegalArgumentException("Es muss ein gültiger Name vergeben werden!");
        }
        else {
            this.Name=Name;
        }
        if (defenseBuff <= 0 && attackBuff <= 0) {
            throw new IllegalArgumentException("Der Wert darf nicht kleiner oder gleich 0 sein!");
        }
        else {
            this.attackBuff=attackBuff;
            this.defenseBuff=defenseBuff;
        }
    }

    public boolean equals(Buff other) {
        boolean helper;
        if (other == null) {
            helper = false;
        }
        else if (Name.equals(other.Name) && defenseBuff == other.defenseBuff && attackBuff == other.attackBuff) {
            helper = true;
        }
        else {
            helper = false;
        }

        return (helper);
    }



    public String getName()
    {
        return Name;
    }

    public static int getAttackBuff() {
        return attackBuff;
    }

    public static int getDefenseBuff() {
        return defenseBuff;
    }

    public void toString(String name, int defenseBuff, int attackBuff)
    {
        System.out.printf("%s (D:%s, A:%s)", name, attackBuff, defenseBuff );
    }
}