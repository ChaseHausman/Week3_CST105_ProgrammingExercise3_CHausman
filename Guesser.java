import java.util.Scanner;

/**
 * Program: Week3, Programming Exercise 3
 * File: Guesser.java
 * Summary: A guessing game program
 * Author: Chase Hausman
 * Date: March 04, 2018
 */
public class Guesser {
    public static void main(String args[]) {
        // Start by generating the target
        int target = (int) (Math.random() * 10000);

        // Initialize Scanner
        Scanner kb = new Scanner(System.in);

        // And initialize variables to determine range and count loops
        int min = 0;
        int max = 10000;
        int tries = 1;

        // Make sure we know when to stop
        boolean correctGuess = false;

        // Keep asking until we have a correct guess
        while(!correctGuess) {
            System.out.println("Enter a guess between " + min + " and " + max + ": ");
            int guess = kb.nextInt();

            if(guess != target) { // Incorrect guess
                tries++; // Increment tries

                if(guess > target) { // Guess needs to be LOWER
                    System.out.println("LOWER");

                    // Find new min/max and display as such, without resetting from a user not following the prompt
                    if(guess < max) {
                        max = guess - 1;
                    }
                } else { // Guess needs to be HIGHER
                    System.out.println("HIGHER");

                    // Find new min/max and display as such
                    if(guess > min) {
                        min = guess + 1;
                    }
                }
            } else { // Correct guess
                System.out.println("You WIN. It took you " + tries + " guesses.");
                correctGuess = true;
            }
        }
    }
}
