package sleepyBarber;

import common.Lock;
import common.RandomBetween;
import common.SemaphoreLock;

public class Index {

    public static void main(String[] args) {

        Lock mutexBarberShop = new SemaphoreLock(1);

        BarberThread barber = new BarberThread(mutexBarberShop);
        BarberShop barberShop = new BarberShop(barber, new Queue(5));
        barber.setBarberShop(barberShop);

        barber.start();

        while(true) {
            try {
                // A cada 1 - 10 segundos um cliente novo entra na barbearia
                Thread.sleep(new RandomBetween().getRandomMilisencodsBetween(1, 3));

                new CustomerThread(mutexBarberShop, barberShop).joinBarberShop();
            } catch (InterruptedException e) {}
        }
    }
}
