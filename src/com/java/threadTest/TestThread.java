package com.java.threadTest;

class subThread extends Thread{
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		for(int i=0;i<10;i++){
			System.out.println(Thread.currentThread().getName()+":"+ i);
		}
	}
}

/**
 * yield():调用此方法的线程释放
 * @author Administrator
 *
 */
public class TestThread {
	public static void main(String[] args) {
		subThread st=new subThread();
		st.start();
		
		for(int i=11;i<20;i++){
			System.out.println(Thread.currentThread().getName()+":"+ i);
			if(i%2==0){
				System.out.println(Thread.currentThread().getName());
				//Thread.currentThread().yield();
				try {
					st.join();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
