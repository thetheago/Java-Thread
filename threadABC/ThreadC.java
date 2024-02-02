package threadABC;

import common.Lock;

public class ThreadC extends Thread {

	private Lock lock;

	private int count = 0;

	public ThreadC(Lock lock) {
		this.lock = lock;
	}
	
	@Override
	public void run() {
		do {
			this.lock.requestCS(NORM_PRIORITY);
			
			System.out.println("Count C | " + ++this.count);
		} while (true);

	}
}
