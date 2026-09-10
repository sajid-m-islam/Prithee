import java.util.Scanner;
public class Main {
    /**
     * This is the class that take user input
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Set initial scores for correct & incorrect
        int correct = 0;
        int incorrect = 0;
        Guesser guesser = new Guesser();

        // Allow user to guess until either score equals 3
        while (correct < 3 && incorrect < 3) {
            // Call checkGuess and interpret return value
            guesser.generateRandomIndexAndWord();
            guesser.printSonnet();

            System.out.println("Guessing: " + guesser.getTargetWord());
            System.out.println("What is the next word? ");
            String userGuess = scanner.nextLine();
            if (guesser.checkGuess(userGuess)) {
                correct++;
            }
            else {
                incorrect++;
            }
        }

        // Print scores
        System.out.println("Correct answers: " + correct);
        System.out.println("Incorrect answers: " + incorrect);
    }
}
