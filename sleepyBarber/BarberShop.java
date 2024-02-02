package sleepyBarber;

public class BarberShop {
    
    private BarberThread barber;
    public Queue queue;

    public BarberShop(BarberThread barber, Queue queue) {
        this.barber = barber;
        this.queue = queue;
    }

    public void wakeUpBarber() {
        this.barber.interrupt();
    }

    public boolean isBarberSleeping() {
        return this.barber.getSleeping();
    }
}
