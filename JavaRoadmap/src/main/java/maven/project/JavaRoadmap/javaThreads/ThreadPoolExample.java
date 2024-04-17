package maven.project.JavaRoadmap.javaThreads;

import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.text.SimpleDateFormat;

/**
 * The class extends runnable and is used as task later in the thread pool
 * @version 1.0
 * @since 2024-04-07
 */
class Tasks implements Runnable {
	private String taskName;

	/**
	 * constructor of the Task class
	 * @param str
	 */
	public Tasks(String str) { 
		taskName = str;
	}

/**
 * implementing the run method of the Runnable iterface
 */
	@Override
	public void run() {
		try {
			for (int j = 0; j <= 5; j++) {
				if (j == 0) {
					Date dt = new Date();
					SimpleDateFormat sdf = new SimpleDateFormat("hh : mm : ss");

					System.out.println("Initialization time for the task name: " + taskName + " = " + sdf.format(dt));

				} else {
					Date dt = new Date();
					SimpleDateFormat sdf = new SimpleDateFormat("hh : mm : ss");

					System.out.println("Time of execution for the task name: " + taskName + " = " + sdf.format(dt));

				}
 
				Thread.sleep(1000);
			}

			System.out.println(taskName + " is complete.");
		}

		catch (InterruptedException ie) {
			ie.printStackTrace();
		}
	}
}

public class ThreadPoolExample {
	static final int MAX_TH = 3;

  
	public static void main(String argvs[]) {
 
		Runnable rb1 = new Tasks("task 1");
		Runnable rb2 = new Tasks("task 2");
		Runnable rb3 = new Tasks("task 3");
		Runnable rb4 = new Tasks("task 4");
		Runnable rb5 = new Tasks("task 5");

//		creating a thread pool with 3 threads, which means it can execute up to 5 threads concurently
		ExecutorService pl = Executors.newFixedThreadPool(MAX_TH);

// 	we pass created tasks to be executed
//		Since we specified that the threadpool has 3 threads and we are passing 5 tasks to that threadpool
//		the thread executes 3 tasks and the reamining tasks are put on hold (in the queue)
//		and are executed when one of the threads is "free"
		pl.execute(rb1);
		pl.execute(rb2);
		pl.execute(rb3);
		pl.execute(rb4);
		pl.execute(rb5);

//		shutdown of the executor
		pl.shutdown();
	}
}
