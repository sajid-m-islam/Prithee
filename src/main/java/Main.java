public class Main {
    /**
     * This is the class that handles calling the checkGuess function
     */
    public static void main(String[] args) {
        // Set initial scores for correct & incorrect
        int correct = 0;
        int incorrect = 0;

        // Allow user to guess until either score equals 3
        while (correct < 3 && incorrect < 3) {
            // Call checkGuess and interpret return value
            if (Guess.checkGuess()) {
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
