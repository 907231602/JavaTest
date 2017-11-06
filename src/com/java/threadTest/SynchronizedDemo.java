package com.java.threadTest;

public class SynchronizedDemo {
	
	public static void main(String[] args) {
		Web12306 web=new Web12306();
		Thread t1=new Thread(web,"t1");
		Thread t2=new Thread(web,"t2");
		Thread t3=new Thread(web,"t3");
		t1.start();
		t2.start();
		t3.start();
	}

}

class Web12306 implements Runnable{
	private int num=10;
	private boolean flag=true;

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(flag) {
			test2();
		}
	}
	//线程安全的
	public synchronized void test2() {
		if(num<=0) {
			flag=false;
			return;
		}
		try {
			Thread.sleep(500);
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName()+"--->"+num--);
		
	}
	
	//线程不安全的
	public void test1() {
		if(num<=0) {
			flag=false;
			return;
		}
		try {
			Thread.sleep(500);
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName()+"--->"+num--);
		
	}
	
}