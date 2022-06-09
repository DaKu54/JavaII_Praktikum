package Aufgabe_II;

public class Buff {

    public String Name;
    public int defenseBuff;
    public int attackBuff;

    /**
     * @param Name
     * @param defenseBuff
     * @param attackBuff
     */
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
        Buff otherObj = (Buff)obj;

        if(Name.equals(otherObj.getName()) && defenseBuff==otherObj.defenseBuff && attackBuff==otherObj.attackBuff)
        {
            return true;
        }
        return false;
    }


    /**
     * @return
     */
    public String getName()
    {
        return Name;
    }

    /**
     * @return
     */
    public int getAttackBuff() {
        return attackBuff;
    }

    public int getDefenseBuff() {
        return defenseBuff;
    }

    public void toString(String Name, int defenseBuff, int attackBuff)
    {
        System.out.printf("%s (D:%s, A:%s)", Name, attackBuff, defenseBuff );
    }
}