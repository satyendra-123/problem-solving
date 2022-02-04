package com.test.thread;

public class ThreadTester {
	public static void main(String[] args) {
		//testExecution();
		//testPrintNumbers();
		testPrintNumber2();
	}

	private static void testPrintNumber2(){
		PrintSequenceRunnable runnable1=new PrintSequenceRunnable(1);
		PrintSequenceRunnable runnable2=new PrintSequenceRunnable(2);
		PrintSequenceRunnable runnable3=new PrintSequenceRunnable(0);

		Thread t1=new Thread(runnable1,"T1");
		Thread t2=new Thread(runnable2,"T2");
		Thread t3=new Thread(runnable3,"T3");

		t1.start();
		t2.start();
		t3.start();
	}

	private static void testExecution(){
		int i = 0;
		ThreadGroup tg = new ThreadGroup("myThreadGroup");
		System.out.println(tg.getParent().getName());//MAIN
		System.out.println(tg.getParent().getParent().getName());//system
		while (i <= 3) {

			Thread t = new Thread(tg, new MyRunnable(), String.valueOf(i+"Thread"));
			t.start();
			/*try {
				t.join();

			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
			try {
				//Thread.yield() //No ORDER
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			};
			i++;
		}
		System.out.println("Main");
	}
}


 class PrintSequenceRunnable implements Runnable{

	public int PRINT_NUMBERS_UPTO=100;
	static  int  number=1;
	int remainder;
	static Object lock=new Object();

	PrintSequenceRunnable(int remainder)
	{
		this.remainder=remainder;
	}

	@Override
	public void run() {
		while (number < PRINT_NUMBERS_UPTO - 1) {
		synchronized (lock) {
				// wait for numbers other than remainder
				if (number % 3 != remainder) try {
					lock.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(Thread.currentThread().getName() + " " + number);
				number++;
				lock.notifyAll();
			}
		}
		//volatilePrintNum();
	}

	private  void volatilePrintNum(){
		while(number < PRINT_NUMBERS_UPTO-1){

			while(number % 3 != remainder){
				//System.out.println(Thread.currentThread().getName() + " waiting " + number +" remainder " +remainder);
			}
				/*if(number == PRINT_NUMBERS_UPTO){
					break;
				}*/

			System.out.println(Thread.currentThread().getName() + " " + number);
			number++;
		}
	}
}

