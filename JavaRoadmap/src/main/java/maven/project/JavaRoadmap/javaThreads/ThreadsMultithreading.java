package maven.project.JavaRoadmap.javaThreads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Class demonstrates the process of working with threads
 * 
 * @version 2.0
 * @since 2024-04-08
 */

public class ThreadsMultithreading {

	public static void main(String[] args) {

//		the currentThread method returns the a reference of the 
//		currently executing thread
		System.out.println("The current thread is: " + Thread.currentThread().getName());

		MyThread threadExt = new MyThread();
		MyThread threadExtMax = new MyThread();
//		start method is used to call the void run() method.
//		when start is called, a new stack is given to the thread,
//		and run() is invoked to produce a new thread in the program
		threadExt.setPriority(Thread.MIN_PRIORITY);
		threadExtMax.setPriority(Thread.MAX_PRIORITY);
		threadExt.start();
		threadExtMax.start();
//		Most common constructors used in Threas Class
//		Thread()
		Thread t1 = new Thread();
		t1.start();

//		Thread(String str)
		Thread th2 = new Thread("Thready");
		th2.start();

//		Thread Runnable
		Thread runnableImpl = new Thread(new MyRunnable());
		runnableImpl.start();

//		Thread(Runnable r, String str)
		Thread runnableTh2 = new Thread(new MyRunnable(), "RunnableTh");
		runnableTh2.start();
		System.out.println("Thread has been created with name: " + runnableTh2.getName());
//		------MULTITHREADING-----
		Thread Example1 = new Thread(new Runnable() {
			@Override
			public void run() {

			}
		});

		Thread Example2 = new Thread(new Runnable() {
			@Override
			public void run() {
			}

		});

		Example1.start();
		Example2.start();
		System.out.println("Threads names are following:");
		System.out.println(Example1.getName());
		System.out.println(Example2.getName());

//		Example of using join method
//		The join() method of the Thread class in Java is used to pause the 
//			execution of the current thread until the thread it joins with 
//			completes its execution.
		Thread th1Join = new Thread(new Runnable() {

			@Override
			public void run() {
				System.out.println("Thread one is running");
			}

		});
		System.out.println(th1Join.getState());
		Thread th2Join = new Thread(new Runnable() {

			@Override
			public void run() {
				th1Join.start(); // th2Join will wait for the th1Join to complete
//				getState is used to get the current state of the thread
				System.out.println(th1Join.getState());
				try {
					th1Join.join();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(th1Join.getState());

				System.out.println("Thread two is running");
			}

		});
		th2Join.start();

//		-------------------STOPPING A THREAD-----------
//		We can stop a thread in two ways: 
//		by using volatile boolean variable
		/**
		 * Inner class that demonstrated the use of volatile boolean variable for
		 * stopping the thread
		 */
		class UsingVolatile implements Runnable {
			public volatile boolean running = true;

			@Override
			public void run() {
				while (running) {
					System.out.println("Volatile threadis running");
				}
				System.out.println("Volatile thread stoped running");
			}

			public void stopRunning() {
				this.running = false;
			}
		}
		UsingVolatile vol = new UsingVolatile();
		Thread stopVolatile = new Thread(vol);
		stopVolatile.start();
		try {
			Thread.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		vol.stopRunning();
//		we cannot start the thread more than one time
//		if we will try to do so we willl get java.lang.IllegalThreadStateException
//		stopVolatile.start();

//		by using Thread.interrupt() method
		/**
		 * Inner class that demonstrates the use of interrupt for stoping a thread
		 */
		class InterruptThread implements Runnable {

			@Override
			public void run() {
				while (!Thread.interrupted()) {
					System.out.println("Thread is not interrupted");
				}

				System.out.println("Thread stoped");
			}

		}

		Thread interuptThread = new Thread(new InterruptThread());
		interuptThread.start();
		try {
			Thread.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		interuptThread.interrupt();

//		using a code that may result in a deadlock
		/*
		 * AvoidingThreadDeadlock caller1 = new AvoidingThreadDeadlock("caller-1");
		 * AvoidingThreadDeadlock caller2 = new AvoidingThreadDeadlock("caller-2");
		 * 
		 * Thread deadlock1 = new Thread(new Runnable() {
		 * 
		 * @Override public void run() { caller1.call(caller2); }
		 * 
		 * });
		 * 
		 * 
		 * Thread deadlock2 = new Thread(new Runnable() {
		 * 
		 * @Override public void run() { caller2.call(caller1); }
		 * 
		 * });
		 * 
		 * deadlock1.start(); deadlock2.start();
		 */

//					-------THREAD POOL------
//		this code creates a thread pool, submits tasks to it, and waits for
//		all tasks to finish.
//		Each task is a WorkerThread that prints a message and imulates
//		time-soncuming task. 
		ExecutorService executor = Executors.newFixedThreadPool(5); // creates a thread pool with 5 threads, which means
																	// that the thread pool can execute up to 5 tasks
																	// concurently
		for (int i = 0; i < 10; i++) {
			Runnable worker = new WorkerThread("" + i);// creates 10 WorkerThread tasks and submits them to the
														// executor.
			executor.execute(worker); // calling execute method of ExecutorService
		}
		executor.shutdown(); // initiates an orderly shutdown of the executor, which means that the executor
								// will stop accepting new tasks and will continue to execute existing tasks
		while (!executor.isTerminated()) {
		} // loop waits for all tasks to finish
		System.out.println("Finished all threads");

//		--------------THREAD GROUP----------
//		creating a thread group
		ThreadGroup tg1 = new ThreadGroup("Group A");
		ThreadGroup tg2 = new ThreadGroup(tg1, "Group B");
		Thread gt1 = new Thread(tg1, new MyRunnable(), "one");
		Thread gt2 = new Thread(tg1, new MyRunnable(), "two");
		Thread gt3 = new Thread(tg1, new MyRunnable(), "three");
		Thread gt4 = new Thread(tg2, new MyRunnable(), "four");
		gt1.start();
		gt2.start();
		gt3.start();
		gt4.start();
		System.out.println("The totl number of active thread groups are " + tg1.activeGroupCount());
		System.out.println("Number of threads in a group " + tg1.activeCount());
		System.out.println("Group name " + tg1.getName());
		tg1.setMaxPriority(8);// his method sets the maximum priority of the group.
		System.out.println("tg2 max priority is " + tg2.getMaxPriority());// getting the group max priority
		System.out.println("the parent of tg2 is " + tg2.getParent()); // getting the group parent group
		tg1.list(); // This method prints information about the thread group to the standard output.
		System.out.println(tg1.toString());
		try {
			gt1.join();
			gt2.join();
			gt3.join();
			gt4.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
//		now we can inerrupt all threads by a single line of code only
		tg2.interrupt(); // interrupts the thread group
		System.out.println("tg2 is inerrupted " + gt4.isInterrupted());
//		Thread.currentThread().interrupt(); //inerrupts the current thread from which this method is called

//		--------------SHUTDOWN HOOK---------------
		ClassForShutdownHook shutdown = new ClassForShutdownHook();
		Runtime.getRuntime().addShutdownHook(shutdown);
//		Runtime.getRuntime().removeShutdownHook(shutdown); // removes the shutdown hook

//		creating shutdown hook using anonymous class
		Runtime.getRuntime().addShutdownHook(new Thread() {
			@Override
			public void run() {
				System.out.println("Shutdown hook from an anonymous class");
			}
		});
		
//		interrupting a thread
		MyThread interuptTh = new MyThread();
		interuptTh.start();
		interuptTh.interrupt();
//		The isInterrupted() method returns the interrupted flag either true or false. 
//		The static interrupted() method returns the interrupted flag afterthat it sets the flag to false if it is true.
		System.out.println("Thread is interrupted: "+interuptThread.isInterrupted());
		
//		-----------------------REENTRANT MONITOR----------------
		Reentrant reentrant = new Reentrant();
		Thread reentrantThread = new Thread() {
			@Override
			public void run() {
				reentrant.m();
			}
		};
		reentrantThread.start();
	}

}

/**
 * Class demonstates one of the way of creating a thread (by extending the
 * Thread class) and also the thread priority
 */
class MyThread extends Thread {
//	The run method is used to create a new thread and to make it runnable
	public void run() {
		System.out.println("Thread is running..." + Thread.currentThread().getPriority());
	}

}

/**
 * The class demonstrates another way of cteating a thread (by implementing
 * Runnable interface)
 */
class MyRunnable implements Runnable {

	@Override
	public void run() {
		System.out.println("The thread Runnable is running...");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

/**
 * Class demonstrates a example of code which may result in a deadlock This code
 * results in a deadlock because both methods call and callMe are synchronized,
 * which means that only one thread can execute the synchronized code at a time.
 * Other threads attempting to enter the synchronized block are blocked until
 * the thread inside the synchronized block exits the block. In this example the
 * call me method is synchromized and it calls the callMe method which is also
 * synchronized. This can lead to a situation where two threads each hold and
 * try to get the lock of the other, resulting in a deadlock.
 * 
 */
class AvoidingThreadDeadlock {
	private final String name;

	public AvoidingThreadDeadlock(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public synchronized void call(AvoidingThreadDeadlock caller) {
		System.out.println(this.getName() + " has asked to call me " + caller.getName());
		try {
//			in this case the sleep() method is used to suspend the thread
//			execution. However while sleeping the thread does not 
//			lose the monitor or lock ownership.
//			which in this case ensures that the other thread gets 
//			a chance to start and lock the other object.
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		caller.callMe(this);
	}

	public synchronized void callMe(AvoidingThreadDeadlock caller) {
		System.out.println(this.getName() + " has called me " + caller.getName());
	}
}

//-----------THREAD POOL-----------
//if we need to execute a lot of tasks concurently, we can either create
//one thread per task, and have each thread execute that one task
//or you can submit the task to a thread pool with a number of precreated threads
//which then execute the task one by one.

//by using a thread pool you can constol how many threds are active at the same time

/**
 * The WorkerThread class implements the Runnable interface.
 */
class WorkerThread implements Runnable {

	private String message;

	/**
	 * constructor of a WorkerThread class
	 * 
	 * @param message
	 */
	public WorkerThread(String message) {
		this.message = message;
	}

	/**
	 * The run() method prints the message and then calls the processMessage method
	 */
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + " (Start) message= " + message);
		processMessage();
	}

	/**
	 * processMessage method simulates the time-consuming task, by making a thread
	 * sleep for 2 seconds
	 */
	private void processMessage() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

/**
 * class that will be used to demonstrate the shutdown hook
 */
class ClassForShutdownHook extends Thread {

	@Override
	public void run() {
		System.out.println("The shutdown hook thread is called");
	}
}

/**
 * Class demonstrates the java reentrant monitor
 * In this class m and n are synchronized methods, and m internally calls the n mehtod
 */
class Reentrant {
	public synchronized void m() {
		n();
		System.out.println("this is m() method");
	}
	
	public synchronized void n() {
		System.out.println("This is n() method");
	}
}
