package threadABC;

import common.Lock;

public class ThreadA extends Thread {

	private Lock lock;

	private int count = 0;

	private int repeatCount;

	public ThreadA(Lock lock, int repeatCount) {
		this.lock = lock;
		this.repeatCount = repeatCount;
	}
	
	@Override
	public void run() {
		for (int i = 0; i < this.repeatCount; i++) {
			System.out.println("Count A | " + ++this.count);
			this.lock.releaseCS(NORM_PRIORITY);
		}
	}
}
