package com.java.threadTest;

public class ThreadOneth {
	public static void main(String[] args) {
		/*Thread1 th1=new Thread1("A");
		Thread1 th2=new Thread1("B");
		th1.start();
		th2.start();*/
		
		ThreadPro pro1=new ThreadPro("One");
		ThreadPro pro2=new ThreadPro("Two");
		pro1.start();
		pro2.start();
		
		
		for(int a=0;a<10;a++) {
			System.out.println("a="+a);
			try {
				pro1.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		/*Runable1 runn= new Runable1("runa");
		Thread runa=new Thread(runn,"hello");
		Thread runb=new Thread(runn,"world");
		runa.start();
		runb.start();*/
		
	}
}

class ThreadPro extends Thread {
	private int num=10;
	private String name;
	
	public ThreadPro(String names) {
		// TODO Auto-generated constructor stub
		this.name=names;
	}
	
	 public void run() {
         // compute primes larger than minPrime
          for(int i=0;i<10;i++) {
                  System.out.println(name+" "+Thread.currentThread().getName()+" "+num--);
        	  try {
        		 Thread.sleep((int)Math.random()*100); //sleep((int)Math.random()*100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
          }
     }

}


class Runable1 implements Runnable{
	private String name;
	private int num=10;
	public Runable1(String name) {
		// TODO Auto-generated constructor stub
		this.name=name;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int a=0;a<10;a++) {
			 if(num<=0)
       		  System.out.println(name+ " 票已卖完"+" "+Thread.currentThread().getName());
       	  else
			System.out.println(name+" -->"+Thread.currentThread().getName()+" "+num--);
		try {
			Thread.sleep((int)Math.random()*10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		
		
	}
	
}


class Thread1 extends Thread{
	private String name;
    public Thread1(String name) {
       this.name=name;
    }
	public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(name + "运行  :  " + i+" "+Thread.currentThread().getName());
            try {
                sleep((int) Math.random() * 10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
       
	}
}