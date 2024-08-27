import java.util.Scanner;

public class GuessNumber {
    public static void main(String[] args) {
        int secretNumber = (int) (Math.random() * 100) + 1;
        int guess;
        int attempts = 0;
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Guess a number between 1 and 100:");

        do {
            guess = scanner.nextInt();
            attempts++;

            if (guess < secretNumber) {
                System.out.println("Too low! Try again:");
            } else if (guess > secretNumber) {
                System.out.println("Too high! Try again:");
            } else {
                System.out.println("Congratulations! You guessed the number in " + attempts + " attempts.");
            }
        } while (guess != secretNumber);

        scanner.close();
    }
}
