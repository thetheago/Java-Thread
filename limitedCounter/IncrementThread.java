package limitedCounter;

import common.RandomBetween;

public class IncrementThread extends Thread {

    UnlimitedCounter counter;

    public IncrementThread (UnlimitedCounter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(new RandomBetween().getRandomMilisencodsBetween(1, 3));
                this.counter.increment();
            } catch (InterruptedException e) {}
        }
    }
}
