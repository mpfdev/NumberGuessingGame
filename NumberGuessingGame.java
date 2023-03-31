import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {

    private int target;

    public int getTarget() {
        return target;
    }

    public NumberGuessingGame() {
        this.target = generateNumber();
    }

    private static int generateNumber() {
        Random random = new Random();
        return random.nextInt(100) + 1;
    }

    public void game() {
        int[] guesses = new int[99];
        Scanner sc = new Scanner(System.in);
        int numberOfTries = 0;
        boolean flag = true;

        while (flag) {
            System.out.print("Guess the number: ");
            int guess = sc.nextInt();

            Arrays.sort(guesses);
            if (Arrays.binarySearch(guesses, guess) < 0) {

                if (guess == getTarget()) {
                    System.out.println("You found the number!");
                    flag = false;
                } else {

                    if (guess < getTarget()) {
                        System.out.println("The number is too low!");
                    } else {
                        System.out.println("The number is too high!");
                    }

                    guesses[numberOfTries] = guess;
                    numberOfTries++;

                }
            } else {
                System.out.println("You already tried this number! Try again!");
            }

        }
    }

}
