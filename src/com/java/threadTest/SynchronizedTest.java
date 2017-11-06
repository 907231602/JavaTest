package com.java.threadTest;

public class SynchronizedTest {
	public static void main(String[] args) {
		Thread t1=new Syncho("A");
		Thread t2=new Syncho("B");
		t1.start();
		t2.start();
		
	}

}

class Syncho extends Thread {
	public Syncho(String name) {
		super(name);
	}
	int a=10;
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		synchronized (this) {
			for(int i=0;i<5;i++) {
				System.out.println(Thread.currentThread().getName()+"--->"+i);
			}
		}
	}
}