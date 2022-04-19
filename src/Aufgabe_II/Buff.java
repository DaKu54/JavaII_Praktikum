package Aufgabe_II;

public class Buff {

    public static String name;
    public static int defenseBuff = 3;
    public static int attackBuff = 4;

    public Buff(String name, int defenseBuff, int attackBuff)
    {

        if(attackBuff == 0 && defenseBuff <= 0)
        {
            throw new IllegalArgumentException("Buffs can not be 0");
        }
        else
        {
            if(attackBuff < 0 || defenseBuff < 0) {
                throw new IllegalArgumentException("Buff can not be negative");
            }
        }
    }

    public boolean equals(Buff otherBuff)
    {
        if(this == otherBuff)
        {
            return true;
        }
        return false;
    }

    public String getName()
    {
        return name;
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