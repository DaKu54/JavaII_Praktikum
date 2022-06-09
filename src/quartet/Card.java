package quartet;

public class Card {
    private String Name;
    private int cylinderCapacity;
    private int cylinderCount;
    private int horsePower;
    private int acceleration;

    public Card(String Name, int cylinderCapacity, int cylinderCount, int horsePower, int acceleration) {

        if(Name==""||Name==null)
        {
            throw new IllegalArgumentException("Name darf nicht null oder leer sein");
        }
        else
        {
            this.Name = Name;
        }
        this.cylinderCapacity = cylinderCapacity;
        this.cylinderCount = cylinderCount;
        this.horsePower = horsePower;
        this.acceleration = acceleration;
    }

    public String toString()
    {
        String ausgabe = "+++ NAME_AUTO +++ \nHubraum:    " + this.cylinderCapacity + "\nZylinder:    " + this.cylinderCount + "\nPS:     " + String.valueOf(this.horsePower) + "\n0 - 100 km/h: " + this.acceleration;
        return ausgabe;
    }

    public String getName() {
        return Name;
    }

    public int getCylinderCapacity() {
        return cylinderCapacity;
    }

    public int getCylinderCount() {
        return cylinderCount;
    }

    public int getHorsePower() {
        return horsePower;
    }

    public int getAcceleration() {
        return acceleration;
    }
}
