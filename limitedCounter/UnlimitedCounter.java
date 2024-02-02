package limitedCounter;

import common.Lock;
import common.RandomBetween;

public class UnlimitedCounter {
    
    private int operationalNumber;
    private int minLimit;
    private int maxLimit;
    private Lock mutexIncrement;
    private Lock mutexDecrement;
    private boolean incrementThreadLocked;
    private boolean decrementThreadLocked;

    public UnlimitedCounter(int minLimit, int maxLimit, Lock mutexIncrement, Lock mutexDecrement) {
        this.minLimit = minLimit;
        this.maxLimit = maxLimit;
        this.operationalNumber = new RandomBetween().getRandomBetween(this.minLimit, this.maxLimit);
        System.out.println("Numero : " + this.operationalNumber);
        this.mutexIncrement = mutexIncrement;
        this.mutexDecrement = mutexDecrement;
    }

    public void increment() {
        if (this.operationalNumber >= this.maxLimit) {
            System.out.println("Não posso mais incrementar");
            this.incrementThreadLocked = true;
            this.mutexIncrement.requestCS(0);
        }

        System.out.println("Incrementando " + this.operationalNumber + " para " + (this.operationalNumber + 1));
        this.operationalNumber++;

        if (this.decrementThreadLocked) {
            this.mutexDecrement.releaseCS(0);
            this.decrementThreadLocked = false;
        }
                
    }

    public void decrement() {
        if (this.operationalNumber <= this.minLimit) {
            System.out.println("Não posso mais decrementar");
            this.decrementThreadLocked = true;
            this.mutexDecrement.requestCS(0);
        }

        System.out.println("Decrementando " + this.operationalNumber + " para " + (this.operationalNumber - 1));
        this.operationalNumber--;

        if (this.incrementThreadLocked) {
            this.mutexIncrement.releaseCS(0);
            this.incrementThreadLocked = false;
        }
    }

}
