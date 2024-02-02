package threadABC;

import common.Lock;
import common.SemaphoreLock;

public class Main {
	
	public static void main(String[] args) {
		
		Lock lock = new SemaphoreLock(0);

		Thread tA = new ThreadA(lock, 1);
		Thread tB = new ThreadB(lock, 1);
		Thread tC = new ThreadC(lock);

		tA.start();
		tB.start();
		tC.start();
		
		
	}
	
	
}
