package com.test.thread;

public class HackerEarthThread {

	public static void main(String[] args) {
		HackerEarth h = new HackerEarth();
		h.start();

		synchronized (h) {
			System.out.println("Hacker");
			try {
				//h.join(); -> wait till its done
				//h.yield(); -> allow 
				//h.wait();//waiting to block the further execution
				System.out.println("released");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		System.out.println("who is using it" +Thread.currentThread().getName());
	}
}

class HackerEarth extends Thread {
	int count = 0;

	public void run() {
		System.out.println("run");
		synchronized (this) {
			for (int i = 0; i <= 75; i++) {
				count = count + i;
			
				try {
					notifyAll();//it doesnt matter wait is waiting to finish the work				

					//Thread.sleep(100);
					//System.out.println("wake up");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			System.out.println(count);
		}
		

	}
}
