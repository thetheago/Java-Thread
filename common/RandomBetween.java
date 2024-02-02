package common;

import java.util.Random;

public class RandomBetween extends Random {

    private int make(int min, int max) {
        return this.nextInt(((max) - (min)) + 1) + (min);
    }

    public int getRandomMilisencodsBetween(int minSeconds, int maxSeconds) {
        return this.make(minSeconds, maxSeconds) * 1000;
    }

    public int getRandomBetween(int min, int max) {
        return this.make(min, max);
    }

}
