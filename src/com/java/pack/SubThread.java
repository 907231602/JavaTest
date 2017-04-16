package com.java.pack;

public class SubThread  {
	public static void main(String[] args) {
		TestThread test=new TestThread();
		test.setPriority(Thread.MIN_PRIORITY);
		test.setName("×ÓÏß³Ì");
		test.start();
		for(int i=0;i<=100;i++){
		System.out.println(Thread.currentThread().getName()+":"+i+","+Thread.currentThread().getPriority());
		/*if(i==20){
			//Thread.currentThread().currentThread();
			try {
				test.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}*/
		}
	}

}

class TestThread extends Thread{
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		
		for(int i=0;i<=100;i++){
			System.out.println(Thread.currentThread().getName()+":"+Thread.currentThread().getPriority()+":"+i);
			
		}
	}
}
