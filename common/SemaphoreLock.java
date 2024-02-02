package common;

import java.util.concurrent.Semaphore;

public class SemaphoreLock implements Lock {

	private final Semaphore sem;
	
	public SemaphoreLock(int permits) {
		this.sem = new Semaphore(permits);
	}

	@Override
	public void requestCS(int pid) {
		boolean keeptrying = false;
		do {
			try {
				sem.acquire();
				keeptrying = false;
			} catch (InterruptedException e) {
				keeptrying = true;
			}
		} while (keeptrying);
	}

	@Override
	public void releaseCS(int pid) {
		sem.release();
	}

}
