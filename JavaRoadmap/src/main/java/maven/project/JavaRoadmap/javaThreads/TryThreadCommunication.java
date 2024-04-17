package maven.project.JavaRoadmap.javaThreads;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * class demonstrates communication between threads when counting even and odd numbers (using synchronized block and reentrant lock)
 * @version 2.0
 * @since 2024-04-10
 */
public class TryThreadCommunication {

	private int count;
	private int until;
/**
 * class constructir that initializes count and until variables
 * @param until
 */
	public TryThreadCommunication(int until) {
		count = 1;
		this.until = until;
	}

	/**
	 * synchronized method that counts even numbers
	 */
	synchronized void countEven() {
		while (count <= until) {
			if (count % 2 == 0) {
				System.out.println(Thread.currentThread().getName() + " = " + count);
				count++;
				notify();
			} else {
				try {
					wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * synchronized method that counts odd numbers
	 */
	synchronized void countOdd() {
		while (count <= until) {
			if (count % 2 != 0) {
				System.out.println(Thread.currentThread().getName() + " = " + count);
				count++;
				notify();
			} else {
				try {
					wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

//	The same but using ReentrantLock
	private final ReentrantLock lock = new ReentrantLock();
	private final Condition isEven = lock.newCondition();
	private final Condition isOdd = lock.newCondition();

	/**
	 * method counts even numbers in synchronized manner using reentrant lock
	 */
	public void incrementEven() {
		lock.lock();
		try {
			while (count < until) {
				while (count % 2 != 0) {
					isEven.await();
				}
				System.out.println(Thread.currentThread().getName() + " = " + count);
				count++;
				isOdd.signal();
			}
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		} finally {
			lock.unlock();
		}
	}

	/**
	 * Method counts odd numbers in synchronized manner using reentrant lock
	 */
	public void incrementOdd() {
		lock.lock();
		try {
			while (count < until) {
				while (count % 2 == 0) {
					isOdd.await();
				}
				System.out.println(Thread.currentThread().getName() + " = " + count);
				count++;
				isEven.signal();
			}
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		} finally {
			lock.unlock();
		}
	}
/**
 * returns the coutn value
 * @return
 */
	public int getCount() {
		return count;
	}

	/**
	 * main method that demonstrates the usage of the synchronized methods and reentrant lock
	 * @param args
	 */
	public static void main(String[] args) {
		TryThreadCommunication commun = new TryThreadCommunication(100);
		Thread th1 = new Thread("ThreadEven") {
			@Override
			public void run() {
				commun.countEven();
			}
		};
		Thread th2 = new Thread(commun::countOdd, "ThreadOdd");
		th1.start();
		th2.start();
		try {
			th1.join();
			th2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

//    	using Reentrant lock
		TryThreadCommunication commun2 = new TryThreadCommunication(50);
		Thread evenThread = new Thread(() -> {
				commun2.incrementEven();
		},"Even");

		Thread oddThread = new Thread(() -> {
				commun2.incrementOdd();
		},"Odd");

		evenThread.start();
		oddThread.start();
	}
}
