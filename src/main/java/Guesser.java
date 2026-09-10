import java.util.Random;
import java.util.Scanner;

public class Guesser {
    /**
     * This is the class that allows users to guess a random word of the sonnet
     */

    private static final String sonnet =
            "Shall I compare thee to a summer’s day?\n" +
            "Thou art more lovely and more temperate:\n" +
            "Rough winds do shake the darling buds of May,\n" +
            "And summer’s lease hath all too short a date;\n" +
            "Sometime too hot the eye of heaven shines,\n" +
            "And often is his gold complexion dimm’d;\n" +
            "And every fair from fair sometime declines,\n" +
            "By chance or nature’s changing course untrimm'd;\n" +
            "But thy eternal summer shall not fade,\n" +
            "Nor lose possession of that fair thou ow’st;\n" +
            "Nor shall death brag thou wander’st in his shade,\n" +
            "When in eternal lines to time thou grow’st:\n" +
            "   So long as men can breathe or eyes can see,\n" +
            "   So long lives this, and this gives life to thee.\n";

    // Make array of strings by splitting on whitespace, include line breaks
    private static final String[] words = sonnet.split("\\h+|(?<=\\n)|(?=\\n)");
    private static final int length = words.length;

    // Private variables
    private int randomIndex;
    private String targetWord;

    // Constructor, no args, calls helper function
    public Guesser() {
        generateRandomIndexAndWord();
    }

    // Getters and setters
    public int getRandomIndex() {
        return randomIndex;
    }

    public void setRandomIndex(int randomIndex) {
        this.randomIndex = randomIndex;
    }

    public String getTargetWord() {
        return targetWord;
    }

    public void setTargetWord(String targetWord) {
        this.targetWord = targetWord;
    }

    // Generates a random index and sets target word to word and that index
    public void generateRandomIndexAndWord() {
        this.randomIndex = (int)(Math.random() * length);

        // Skips new line character
        while (words[randomIndex].equals("\n")) {
            this.randomIndex = (int)(Math.random() * length);
        }
        this.targetWord = words[randomIndex].replaceAll("[^a-zA-Z]", "");

    }

    // Prints the sonnet up to the target word and prints underscores in place of the target word
    public void printSonnet() {
        // Print sonnet up to target word
        for (int i = 0; i < this.randomIndex; i++) {
            if (words[i].equals("\n")) {
                System.out.print("\n");
            }
            else {
                System.out.print(words[i] + " ");
            }
        }

        // Print underscores for length of target word
        for (int j = 0; j < this.targetWord.length(); j++) {
            System.out.print("_");
        }
        System.out.println();
    }

    // Gets a random word and checks user's guess
    public boolean checkGuess(String userGuess) {
        // Check if guess is correct
        if (userGuess.equalsIgnoreCase(targetWord)) {
            System.out.println("Correct!");
            return true;
        }
        System.out.println("Incorrect.");
        return false;
    }
}
