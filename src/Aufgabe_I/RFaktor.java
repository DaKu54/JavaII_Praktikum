package Aufgabe_I;

public class RFaktor {
    public static void main(String[] args) {
        double infected = 100;
        double rFactor = 1.1;
        int iterations = 10;
        int i = 1;
        System.out.printf("Initial: %.6f %n", infected);

        while (iterations > 0) {
            infected *= rFactor;
            System.out.printf("Iteration %s: %.6f %n", i, infected);
            i++;
            iterations--;
        }

    }
}
