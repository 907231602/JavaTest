package com.java.threadTest;

//守护线程
/**
 * 守护线程的唯一作用就是为其他线程提供服务。计时线程就是一个典型的例子，它定时地发送“计时器滴答”信号告诉其他线程去执行某项任务。
 * 当只剩下守护线程时，虚拟机就退出了，因为如果只剩下守护线程，程序就没有必要执行了。另外JVM的垃圾回收、内存管理等线程都是守护线程。
 * 还有就是在做数据库应用时候，使用的数据库连接池，连接池本身也包含着很多后台线程，监控连接个数、超时时间、状态等等。
 * 最后还有一点需要特别注意的是在java虚拟机退出时Daemon线程中的finally代码块并不一定会执行哦，
 * @author Administrator
 *
 */
public class DemonTest {
	public static void main(String[] args) {  
        Thread deamon = new Thread(new DaemonRunner(),"DaemonRunner");  
      
        Thread demo=new Thread(new Demo(), "demo");
        demo.start();
        
        //设置为守护线程  
        deamon.setDaemon(true);  
        deamon.start();//启动线程  
        
     
    }  
      
      
    static class DaemonRunner implements Runnable{  
        @Override  
        public void run() {  
            try {  
            	System.out.println("I'm daem");
                Thread.sleep(500);  
            } catch (InterruptedException e) {  
                e.printStackTrace();  
            }finally{  
                System.out.println("这里的代码在java虚拟机退出时并不一定会执行哦！");  
            }  
        }  
    }  
    
   
}

class Demo implements Runnable{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("I'm not deam");
	}
	
}
