package maven.project.JavaRoadmap.javaThreads;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Class demostrates the threads exercises (not finished)
 * @version 1.0
 * @since 2024-04-06
 */
public class ThreadPrograms {
//	producer consumer problem 
	
	private Queue<Integer> queue = new LinkedList<>();
	private final int size = 10;
	
/**
 * synchronized method that inserts the number into the queue
 * @param n the number to be inserted
 */
	public void push(int n) {
		synchronized (this) {
			while (queue.size() == size) {
				try {
					wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			queue.add(n);
			System.out.println("Pushed " + n);
			notify();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * the method extracts the number from the queue
	 */
	public void pop() {
		synchronized (this) {
			while (queue.size() == 0) {
				try {
					wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			System.out.println("Pulled " + queue.poll());
			;
			notify();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

//	write a java program that uses ReentrantLock 
	ReentrantLock lock = new ReentrantLock();
	Condition condition1 = lock.newCondition();
	Condition condition2 = lock.newCondition();

	/**
	 * Method demonstartes adding number to the queue using reentrantLock
	 * @param n
	 */
	public void pushReentrant(int n) {
	    lock.lock();
	    try {
	        while (queue.size() == size) {
	            try {
	                condition1.await();
	            } catch (InterruptedException e) {
	                e.printStackTrace();
	            }
	        }
	        queue.add(n);
	        System.out.println("Pushed " + n);
	        condition2.signal();
	        try {
	            Thread.sleep(400);
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
	    } finally {
	        lock.unlock();
	    }
	}

	/**
	 * Method demonstrates number removal from the queue using reentrant lock
	 */
	public void popReentrant() {
	    lock.lock();
	    try {
	        while (queue.size() == 0) {
	            try {
	                condition2.await();
	            } catch (InterruptedException e) {
	                e.printStackTrace();
	            }
	        }
	        System.out.println("Pulled " + queue.poll());
	        condition1.signal();
	        try {
	            Thread.sleep(400);
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
	    } finally {
	        lock.unlock();
	    }
	}

/**
 * Main method that demonstrates the usage of procuder concumer problem using synchronization and reentrant lock
 * @param args
 */
	public static void main(String[] args) {
//		producer consumer problem 
		ThreadPrograms prog = new ThreadPrograms();
		Thread th1 = new Thread(() -> {
			for (int i = 0; i < 20; i++) {
				prog.push(i);
			}
		});

		Thread th2 = new Thread(() -> {
			for (int i = 0; i < 20; i++) {
				prog.pop();
			}
		});

		th1.start();
		th2.start();

		try {
			th1.join();
			th2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
//		reentrant lock
		Thread th1Re = new Thread(() -> {
			for (int i = 0; i < 20; i++) {
				prog.pushReentrant(i);
			}
		});

		Thread th2Re = new Thread(() -> {
			for (int i = 0; i < 20; i++) {
				prog.popReentrant();
			}
		});
		th1Re.start();
		th2Re.start();
		try {
			th1Re.join();
			th2Re.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
