package sleepyBarber;

import common.Lock;
import common.RandomBetween;

public class BarberThread extends Thread {

    public Lock lock;
    private BarberShop barberShop;
    private boolean sleeping;

    public BarberThread(Lock lock) {
        this.lock = lock;
    }

    public boolean getSleeping() {
        return this.sleeping;
    }

    public void setBarberShop(BarberShop barberShop) {
        this.barberShop = barberShop;
    }

    private void sleep() {
        try {
            System.out.println("Barbeiro | Não há ninguém na fila, barbeiro está dormindo zZZ");
            this.sleeping = true;
            this.lock.releaseCS(MAX_PRIORITY);

            Thread.sleep(1000000);
        } catch (InterruptedException e) {
            this.sleeping = false;
            System.out.println("Barbeiro | Acordou !!!");
        }
    }

    private void cutCustomersHair(CustomerThread cliente) {
        System.out.println("Barbeiro | Cortando cabelo do cliente " + cliente.getName());

        this.lock.releaseCS(MAX_PRIORITY);

        try {
            Thread.sleep(new RandomBetween().getRandomMilisencodsBetween(1, 10));
        } catch (InterruptedException e) {}

        System.out.println("Barbeiro | Terminou de cortar o cabelo do " + cliente.getName() + "\n");

    }

    @Override
    public void run() {
        this.lock.requestCS(MAX_PRIORITY);

        System.out.println("Barbeiro | Está na barbearia pronto para cortar cabelo.");

        while (true) {

            this.lock.releaseCS(MAX_PRIORITY);

            System.out.println("Barbeiro | Checando se há alguem na fila");
            if(this.barberShop.queue.thereIsSomeoneInQueue()) {
                System.out.println("Barbeiro | Pegando primeiro cliente da fila");
    
                CustomerThread customer = this.barberShop.queue.getFirstCustomerInQueue();
                
                this.cutCustomersHair(customer);
            } else {
                this.sleep();
            }
        }
    }
}
