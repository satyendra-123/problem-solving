package com.test.thread;

public class MyRunnable implements Runnable{

	@Override
	public void run() {
		System.out.println("run "+Thread.currentThread().getName()+" : "+Thread.currentThread().getState()+ " :: "+Thread.currentThread().getThreadGroup().getName());	
	}
}
