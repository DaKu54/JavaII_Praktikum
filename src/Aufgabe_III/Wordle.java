package Aufgabe_III;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Random;
import java.util.Scanner;

public class Wordle {

    // TODO: implement this method!
    private static String[] getWords(int minFreq){
        // TODO
        //  - read line-by-line
        //  - skip if ...
        //    - word is not a noun (NoC)
        //    - word contains a non-alpha character
        //    - frequency is below minFreq
        //    - last letter is 's'
        //    - if length != 5
        //  - convert to upper case
        //  - append to StringBuilder (with separator)
        //  - split result to array

        String words = readAllLinesFromDict();
        String [] split1 = words.split("\n");
        String [] split2;
        boolean test = true;
        StringBuilder builder = new StringBuilder(10);

        for(String s : split1){
            if (!s.contains("NoC"))
                continue;
            split2 = s.split("\t");
            for(int x = 0; x < split2[0].length(); x++) {
                if (!Character.isLetter(split2[0].charAt(x)))
                    test = false;
                break;
            }
            if (test) {
                if(Integer.parseInt(split2[2]) < minFreq)
                    continue;
                if(split2[0].substring(split2[0].length()-1, split2[0].length()).equals("s"))
                    continue;
                if(split2[0].length() != 5)
                    continue;
            }
            else
                continue;
            if (test)
                builder.append(split2[0]+ ":");
        }

        builder.delete(builder.length()-1, builder.length());
        String [] finish = builder.toString().split(":");
        return finish;
    }

    public static void main(String[] args) {
        String[] candidates = getWords(15);
        playWordle(candidates);
    }

    private static String readAllLinesFromDict(){
        try {
            return Files.readString(Path.of("words.txt"));
        } catch (IOException e){
            e.printStackTrace();
            throw new UncheckedIOException(e);
        }

    }


    private static void playWordle(String[] words){
        Scanner scanner = new Scanner(System.in);
        boolean finished = false;
        int tries = 0;

        String secret = words[(new Random()).nextInt(words.length)];
        java.util.Set<String> set = java.util.Set.of(words);

        System.out.printf("Number of words in dictionary: %d%n", words.length);
        System.out.println("Guess the secret word! You have 6 guesses!");

        while (!finished){

            String input = scanner.nextLine();

            if (input.length() != 5){
                System.out.println("Please enter exactly 5 characters");
                continue;
            }

            if (!set.contains(input.toUpperCase())){
                System.out.println("Word is not in dictionary!");
                continue;
            }


            int matches = 0;


            for (int i = 0; i < 5; i++){

                char inputChar = Character.toUpperCase(input.charAt(i));

                if (inputChar == secret.charAt(i)){
                    System.out.print(inputChar);
                    matches++;
                } else if (secret.indexOf(inputChar) != -1){
                    System.out.print("?");
                } else {
                    System.out.print("!");
                }
            }

            System.out.println();

            if (matches == 5){
                System.out.println("You guessed right!");
                finished = true;
            }

            tries++;

            if (tries == 6){
                System.out.println("No tries left!");
                System.out.printf("The word was: %s", secret);
                finished = true;
            }

        }

    }


}
