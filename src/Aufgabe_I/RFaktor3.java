package Aufgabe_I;

import java.util.Scanner;

public class RFaktor3 {

    public static void main(String[] args) {


        System.out.printf("java RFactor ");

        Scanner scan = new Scanner(System.in);

        String[] numbers = new String[10];


        numbers[0] = scan.next();
        numbers[1] = scan.next();
        numbers[2] = scan.next();

        scan.close();

        double infected = Double.parseDouble(numbers[0]);
        double rFactor = Double.parseDouble(numbers[1]);
        int iterations = Integer.parseInt(numbers[2]);
        int counter = 1;

        if (infected < 0.0) {
            System.out.println("Amount of infected people cannot be negative!");
            return;
        }

        if (iterations < 0.0) {
            System.out.println("Number of iterations cannot be negative!");
            return;
        }

        while (iterations > 0) {
            infected *= rFactor;
            System.out.printf("Iteration %s: %.6f %n", counter, infected);
            counter++;
            iterations--;
            if (infected <0.1 ) {
                System.out.println("The pandemic is over!");
                return;
            }
        }
    }
}