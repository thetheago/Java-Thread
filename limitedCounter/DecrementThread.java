package limitedCounter;

import common.RandomBetween;

public class DecrementThread extends Thread {

    UnlimitedCounter counter;

    public DecrementThread (UnlimitedCounter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(new RandomBetween().getRandomMilisencodsBetween(1, 3));
                this.counter.decrement();
            } catch (InterruptedException e) {}
        }
    }
}
