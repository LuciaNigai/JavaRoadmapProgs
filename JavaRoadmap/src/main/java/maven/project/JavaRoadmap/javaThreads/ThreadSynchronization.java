package maven.project.JavaRoadmap.javaThreads;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Class demonstrates the different ways of thread synchronization, like synchronized blocks(methods) and reentrant lock
 */
public class ThreadSynchronization {

	public static void main(String[] args) {

//	demonstrating the paralel thread execution without synchronization
		System.out.println("Printing data using unsychronized method");
		Table table = new Table();
		MyThread1 th1 = new MyThread1(table);
		MyThread2 th2 = new MyThread2(table);

		th1.start();
		th2.start();
	
		try {
			th1.join();
			th2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
//		demonstrating the synchronized paralel threads execution
		System.out.println("Printing the data using synchronized method");
		TableSynchronized tableSynchronized = new TableSynchronized();
		Thread thSync1 = new Thread() {
			@Override
			public void run() {
				tableSynchronized.printTable(5);
			}
		};
		Thread thSync2 = new Thread() {
			@Override
			public void run() {
				tableSynchronized.printTable(100);
			}
		};
		
		thSync1.start();
		thSync2.start();
		
		try {
			thSync1.join();
			thSync2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
//		demonstrating synchronized block
		System.out.println("Synchronized block");
		TableSynchronizedBlock syncBlock = new TableSynchronizedBlock();
		Thread thSyncBlock1 = new Thread() {
			@Override
			public void run() {
				syncBlock.printTable(5);
				try {
					Thread.sleep(400);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};
		
		Thread thSyncBlock2 = new Thread() {
			@Override
			public void run() {
				syncBlock.printTable(100);
				try {
					Thread.sleep(400);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};
		thSyncBlock1.start();
		thSyncBlock2.start();
		try {
			thSyncBlock1.join();
			thSyncBlock2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
//		the use of the static synchronized method
		System.out.println("Static synchronized method");
		Thread staticSynch1 = new Thread() {
			@Override
			public void run() {
				TableStaticSync.printTable(5);
			}
		};
		
		Thread staticSync2 = new Thread() {
			@Override
			public void run() {
				TableStaticSync.printTable(200);
			}
		};
		staticSynch1.start();
		staticSync2.start();
		try {
			staticSynch1.join();
			staticSync2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
//		-------Reentrant lock
		ReentrantLockExample exReentrant = new ReentrantLockExample();
		Thread thReentrantLock = new Thread(exReentrant::increment);
		Thread thReentrantLock2 = new Thread(exReentrant::increment);
		
		thReentrantLock.start();
		thReentrantLock2.start();
		
		try {
			thReentrantLock.join();
			thReentrantLock2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}

/**
 * Class that demonstrates the usage of unsychronized threads
 */

class Table {
	void printTable(int n) {
		for (int i = 0; i < 5; i++) {
			System.out.println(n * i);
			try {
				Thread.sleep(400);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}


/**
 * Class demonstrates the synchronized method
 */
class TableSynchronized {
//	Synchronized method is used to lock an object for any shared resource.
//	When a thread invokes a synchronized method, it automatically acquires the lock for that object and releases it when the thread completes its task.
	synchronized void printTable(int n) {
		for (int i = 0; i < 5; i++) {
			System.out.println(n * i);
			try {
				Thread.sleep(400);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
}

/**
 * Clss demonstrates the synchronized block
 */
class TableSynchronizedBlock{
	public void printTable(int n) {
		synchronized (this) {
			for (int i = 0; i < 5; i++) {
				System.out.println(n * i);
				try {
					Thread.sleep(400);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
}

/**
 * class demonstrates the static synchronized block
 */
class TableStaticSync{
	synchronized static void printTable(int n) {
		for(int i=0; i<5; i++) {
			System.out.println(n*i);
			try {
				Thread.sleep(400);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
//	equivalent to
	/*static void printTable(int n){
	 * 	synchronized(Table.class){
	 * ...
	 * }
	 * }
	 */
}

/**
 * Class demonstrates the use of reentrant lock
 * In this example, a ReentrantLock is used to ensure that increments of the count variable are thread-safe. The lock.lock() method is called before the increment operation to ensure that only one 
 * thread can execute the code block at a time. The lock.unlock() method is called in a finally block to ensure that the lock is released even if an exception occurs.
 */
class ReentrantLockExample{
	private final ReentrantLock reentrantLock = new ReentrantLock();
	private int count=0;
	public void increment() {
		reentrantLock.lock();
		System.out.println("Reentrant lock locked");
		try {
			count++;
			System.out.println("Count incremented "+count);
		}
		finally{
			reentrantLock.unlock();
			System.out.println("reentrant lock released");
		}
	}
}

class MyThread1 extends Thread {
	Table t;

	public MyThread1(Table t) {
		this.t = t;
	}

	public void run() {
		t.printTable(5);
	}
}

class MyThread2 extends Thread {
	Table t;

	public MyThread2(Table t) {
		this.t = t;
	}

	public void run() {
		t.printTable(100);
	}
}