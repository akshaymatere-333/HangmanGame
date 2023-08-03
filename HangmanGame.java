//TASK 2 - Implement a simple game:
//create a simple game such as tic-tac-toe or hangman using java.


import java.util.Scanner;
import java.util.Random;

public class HangmanGame {
    private static final String[] WORDS = {"JAVA", "PYTHON", "C++", "JAVASCRIPT", "HTML", "CSS"};
    private static final int MAX_TRIES = 6;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("Welcome to Hangman!");
        String wordToGuess = WORDS[random.nextInt(WORDS.length)].toUpperCase();
        StringBuilder guessedWord = new StringBuilder(wordToGuess.length());

        for (int i = 0; i < wordToGuess.length(); i++) {
            guessedWord.append("_");
        }

        int attempts = 0;
        while (attempts < MAX_TRIES && guessedWord.toString().contains("_")) {
            System.out.println("Word: " + guessedWord);
            System.out.print("Enter a letter: ");
            char guess = scanner.next().toUpperCase().charAt(0);

            if (!Character.isLetter(guess)) {
                System.out.println("Invalid input. Please enter a letter.");
                continue;
            }

            boolean found = false;
            for (int i = 0; i < wordToGuess.length(); i++) {
                if (wordToGuess.charAt(i) == guess) {
                    guessedWord.setCharAt(i, guess);
                    found = true;
                }
            }

            if (found) {
                System.out.println("Correct!");
            } else {
                attempts++;
                System.out.println("Incorrect. Attempts remaining: " + (MAX_TRIES - attempts));
            }
        }

        if (guessedWord.toString().equals(wordToGuess)) {
            System.out.println("Congratulations! You guessed the word: " + wordToGuess);
        } else {
            System.out.println("Sorry, you're out of attempts. The word was: " + wordToGuess);
        }

        scanner.close();
    }
}
