package Aufgabe_II;

public class TradingCardsMain {

    /**
     * @param args
     */
    public static void main(String[] args) {

        var defenseBuff = new Buff("Defense", 2, 0);
        var rageBuff = new Buff("Rage", -2, 4);

        System.out.println(rageBuff);
        System.out.println(defenseBuff);
        System.out.println();

        for (Category kategorie : Category.values()) {
            System.out.println(kategorie);
        }
        System.out.println();

        var wolf = new Card("Wolf", 3, 1, Category.ANIMAL, 2);
        System.out.println(wolf);
        var lawnMower = new Card("Lawn Mower", 1, 3, Category.MACHINE, 4);
        System.out.println(lawnMower);
        var unicorn = new Card("Unicorn", 3, 3, Category.MAGICAL_CREATURE, 1);
        System.out.println(unicorn);
        var machineelTree = new Card("Machineel Tree", 4, 1, Category.PLANT, 5);
        System.out.println(machineelTree);
        System.out.println();

        var wolf_neu = new Card("Wolf", 3, 1, Category.ANIMAL, 2);
        System.out.println(wolf_neu.equals(wolf));

        wolf.attack(lawnMower);
        System.out.println(lawnMower);
        lawnMower.setBuff(defenseBuff);
        System.out.println(lawnMower);
        wolf.attack(lawnMower);
        System.out.println(lawnMower);
        lawnMower.attack(wolf);
        System.out.println(wolf);
        unicorn.attack(machineelTree);
        System.out.println(machineelTree);
        machineelTree.setBuff(rageBuff);
        System.out.println(machineelTree);
        machineelTree.attack(unicorn);
        System.out.println(unicorn);
        System.out.println(wolf.isAlive());
        //unicorn.attack(machineelTree);

    }

}
