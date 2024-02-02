package limitedCounter;

import common.Lock;
import common.SemaphoreLock;

public class Index {
    
    public static void main(String[] args) {

        Lock mutexIncrement = new SemaphoreLock(0);
        Lock mutexDecrement = new SemaphoreLock(0);
        UnlimitedCounter counter = new UnlimitedCounter(0, 3, mutexIncrement, mutexDecrement);
        
        IncrementThread incrementThread = new IncrementThread(counter);
        DecrementThread decrementThread = new DecrementThread(counter);

        incrementThread.start();
        decrementThread.start();


    }
}
