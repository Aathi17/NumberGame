package numgame;
import java.util.Random;
import java.util.Scanner;

	public class Game {
	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        Random random = new Random();

	        System.out.println("Welcome to the Guess the Number Game!");
	        boolean playAgain = true;
	        int score = 0;

	        while (playAgain) {
	            // Generate a random number within the specified range
	            int secretNumber = random.nextInt(100) + 1;
	            int attempts = 0;
	            int maxAttempts = 5; // You can adjust the maximum number of attempts

	            System.out.println("\nRound " + (score + 1) + ": New Game! Guess the number between 1 and 100.");

	            while (attempts < maxAttempts) {
	                try {
	                    // Prompt user for a guess
	                    System.out.print("Enter your guess: ");
	                    int userGuess = scanner.nextInt();

	                    // Compare the user's guess with the generated number
	                    if (userGuess == secretNumber) {
	                        System.out.println("Congratulations! You guessed the correct number " + secretNumber +
	                                " in " + (attempts + 1) + " attempts.");
	                        break;
	                    } else if (userGuess < secretNumber) {
	                        System.out.println("Too low! Try again.");
	                    } else {
	                        System.out.println("Too high! Try again.");
	                    }

	                    attempts++;
	                } catch (java.util.InputMismatchException e) {
	                    System.out.println("Invalid input. Please enter a valid number.");
	                    scanner.next(); // Clear the buffer
	                }
	            }

	            if (attempts == maxAttempts) {
	                System.out.println("Sorry, you've run out of attempts. The correct number was " + secretNumber + ".");
	            }

	            // Ask if the user wants to play again
	            System.out.print("Do you want to play again? (yes/no): ");
	            String playAgainInput = scanner.next().toLowerCase();
	            if (!playAgainInput.equals("yes")) {
	                System.out.println("\nGame Over! Your final score is " + score + ".");
	                break;
	            } else {
	                score++;
	            }
	        }

	        scanner.close();
	    }
	}



