package threadABC;

import common.Lock;

public class ThreadB extends Thread {

	private Lock lock;

	private int count = 0;

	private int repeatCount;

	public ThreadB(Lock lock, int repeatCount) {
		this.lock = lock;
		this.repeatCount = repeatCount;
	}
	
	@Override
	public void run() {
		for (int i = 0; i < this.repeatCount; i++) {
			System.out.println("Count B | " + ++this.count);			
			this.lock.releaseCS(NORM_PRIORITY);
		}

	}
}
