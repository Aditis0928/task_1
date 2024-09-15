package numberguessgame;
import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        boolean playAgain = true;
        int score = 0;
        
        while (playAgain) {
            int numberToGuess = random.nextInt(100) + 1;
            int numberOfAttempts = 5;
            boolean hasGuessedCorrectly = false;

            System.out.println("Guess the number between 1 and 100. You have " + numberOfAttempts + " attempts.");
            
            while (numberOfAttempts > 0 && !hasGuessedCorrectly) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();
                
                if (userGuess == numberToGuess) {
                    System.out.println("Congratulations! You guessed the correct number.");
                    hasGuessedCorrectly = true;
                    score++;
                } else if (userGuess < numberToGuess) {
                    numberOfAttempts--;
                    System.out.println("Too low! Attempts remaining: " + numberOfAttempts);
                } else {
                    numberOfAttempts--;
                    System.out.println("Too high! Attempts remaining: " + numberOfAttempts);
                }
            }
            
            if (!hasGuessedCorrectly) {
                System.out.println("Sorry, you've run out of attempts. The correct number was " + numberToGuess);
            }
            
            System.out.print("Would you like to play again? (yes/no): ");
            String userResponse = scanner.next();
            playAgain = userResponse.equalsIgnoreCase("yes");
        }
        
        System.out.println("Game over! Your final score is: " + score);
        scanner.close();
    }
}
