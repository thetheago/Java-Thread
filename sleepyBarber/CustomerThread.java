package sleepyBarber;

import common.Lock;

public class CustomerThread extends Thread {
    
    private Lock lock;
    private BarberShop barberShop;

    public CustomerThread(Lock lock, BarberShop barberShop) {
        this.lock = lock;
        this.barberShop = barberShop;
    }

    public void joinBarberShop() {
        System.out.println(this.getName() + " | Entrando na barbearia.");

        this.start();
    }

    @Override
    public void run() {
        
        this.lock.requestCS(NORM_PRIORITY);
        
        System.out.println(this.getName() + " | Tentando entrar na fila.");

        if(this.barberShop.queue.join(this)) {
            
            System.out.println(this.getName() + " | Entrou na fila.");

            if (this.barberShop.isBarberSleeping())
                this.barberShop.wakeUpBarber();

            this.lock.releaseCS(NORM_PRIORITY);

        } else {
            this.lock.releaseCS(NORM_PRIORITY);
            System.out.println(this.getName() + " | Fila está cheia, cliente indo embora!");
        }
    }
}
