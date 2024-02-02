package sleepyBarber;

import java.util.LinkedList;

public class Queue {

    private LinkedList<CustomerThread> queue;
    private int seatLimit;

    public Queue(int seatLimit) {
        this.queue = new LinkedList<CustomerThread>();
        this.seatLimit = seatLimit;
    }

    public boolean join(CustomerThread clienteThread) {

        // Checa se a fila está cheia
        if (this.seatLimit == this.queue.size())
            return false;

        // Entrou na fila
        this.queue.add(clienteThread);
        return true;
    }

    public CustomerThread getFirstCustomerInQueue() {
        return this.queue.poll();
    }

    public boolean thereIsSomeoneInQueue() {
        if (this.queue.size() > 0)
            return true;

        return false;
    }
}
