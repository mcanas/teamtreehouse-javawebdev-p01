import java.util.Random;

/**
 * Created by mcanas on 9/16/16.
 */
public class Jar {
    private String mName;
    private int mMin;
    private int mMax;
    private int mAmount;
    private int mGuesses;
    private boolean mIsSolved;

    public Jar(String name, int max) {
        mMin = 1;
        mMax = max;
        mName = name;
        mIsSolved = false;
        mGuesses = 0;
        mAmount = fill(mMin, mMax);
    }

    public int fill(int min, int max) {
        Random r = new Random();
        int num = 0;

        do {
            num = r.nextInt(max) + min;
        } while( num == 0 );

        return num;
    }

    public int getAmount() {
        return mAmount;
    }

    public int getGuesses() {
        return mGuesses;
    }

    public int getMax() {
        return mMax;
    }

    public int getMin() {
        return mMin;
    }

    public String getName() {
        return mName;
    }

    public int applyGuess(int guess) throws IllegalArgumentException {
        if(guess > mMax) {
            throw new IllegalArgumentException("Your guess must be less than "+mMax);
        }

        mGuesses++;

        if(guess > mAmount) {
            return 1;
        }

        if(guess < mAmount) {
            return -1;
        }

        mIsSolved = true;
        return 0;
    }

    public boolean isSolved() {
        return mIsSolved;
    }
}
