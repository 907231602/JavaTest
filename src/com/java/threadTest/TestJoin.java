package com.java.threadTest;

public class TestJoin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Thread t=new JoinOne();
		Thread t2=new Thread( new JoinTwo());
		t.start();
		t2.start();
		try {
			t.join();
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("main end");
		
		/*JoinTwo jj=new JoinTwo();
		Thread aa=new Thread(jj);
		Thread bb=new Thread(jj);
		Thread cc=new Thread(jj);
		aa.start();
		bb.start();
		cc.start();*/
		
		
	}
	
	

}

class JoinTwo implements Runnable{
	
	private int a=10;

	@Override
	public void run() {
		// TODO Auto-generated method stub
		/*synchronized (this) {
			
		}*/
		System.out.println("this---"+this);
		for(int i=0;i<10;i++) {
		
		System.out.println( Thread.currentThread().getName()+" "+a--);
		try {
			Thread.sleep(30);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		
	}
	
}


class JoinOne extends Thread{
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("run start");
		try {
			sleep(20);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("run end");
	}
}