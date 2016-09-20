/**
 * Created by mcanas on 9/16/16.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Prompter {
    private BufferedReader mReader;
    private Jar mJar;

    public Prompter() {
        mReader = new BufferedReader(new InputStreamReader(System.in));
    }

    public void startNewGame() throws IOException {
        String name = promptForName();
        int max = promptForMaximum(name);

        mJar = new Jar(name, max);
    }

    public String promptForName() throws IOException {
        System.out.printf("What type of item? ");
        return mReader.readLine();
    }

    public int promptForMaximum(String name) throws IOException {
        int max = 0;

        do {
            System.out.printf("What is the maximum amount of %s? ", name);
            max = Integer.parseInt(mReader.readLine());
        } while(max == 0);

        return max;
    }

    public void play() throws IOException {
        System.out.printf("How many %s are in the jar? Pick a number between %s and %s%n", mJar.getName(), mJar.getMin(), mJar.getMax());

        while(!mJar.isSolved()) {
            promptForGuess();
        }

        if(mJar.isSolved()) {
            int attempts = mJar.getGuesses();
            if(attempts > 1) {
                System.out.printf("You got it in %s attempts.%n", attempts);
            } else {
                System.out.printf("You got it in %s attempt.%n", attempts);
            }
        }
    }

    public void promptForGuess() throws IOException {
        System.out.printf("Guess: ");
        int guess = Integer.parseInt(mReader.readLine());

        try {
            switch(mJar.applyGuess(guess)) {
                case 1:
                    System.out.printf("Your guess is too high.%n");
                    break;
                case -1:
                    System.out.printf("Your guess is too low.%n");
                    break;
                default:
                    return;
            }
        } catch(IllegalArgumentException e) {
            System.out.printf("%s%n",e.getMessage());
        }
    }
}
