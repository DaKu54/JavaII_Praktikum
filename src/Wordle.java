import java.util.Scanner;

public class Wordle {

    public static void main(String[] args) {
        String word = "TASSE";
        int guessCount = 6;
        Scanner scan = new Scanner(System.in);

        String msg = String.format("Guess the secret word! You have %s guesses", guessCount);
        System.out.println(msg);

        while(guessCount > 0) {
            String current = scan.nextLine();
            char currentChar[] = current.toCharArray();
            //Transform all chars to UpperCase
            int index = 0;
            for (char c: currentChar) {
                currentChar[index]= Character.toUpperCase(c);
                index++;
            }

            // Player wins
            if (new String(currentChar).equals(word)){
                System.out.println("You guessed right!");
                scan.close();
                return;
            }

            if(current.length() == word.length()) {

                index = 0;
                //comparison
                for (char c : currentChar) {
                    //c is in the word
                    if (word.contains(String.valueOf(c))) {
                        if (c != word.charAt(index)) {
                            currentChar[index] = '?';
                        }
                        // else, it stays the same; thus was right
                    }
                    // case c is not in the word
                    else {
                        currentChar[index] = '!';
                    }
                    index++;
                }
                String result = new String(currentChar);
                System.out.println(result);

                guessCount--;

                if(guessCount < 0) {
                    System.out.println("No guesses left");
                    scan.close();
                }
            }
            else {
                System.out.println("Please enter exactly 5 letters");
            }
        }
        scan.close();
    }
}
