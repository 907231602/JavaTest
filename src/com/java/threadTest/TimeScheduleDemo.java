package com.java.threadTest;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * 生产者消费者问题
 * 
 * Timer() -----  任务调度
 * @author Administrator
 * schedule(TimerTask task, Date time) 
          安排在指定的时间执行指定的任务。
          
  void schedule(TimerTask task, Date firstTime, long period) 
          安排指定的任务在指定的时间开始进行重复的固定延迟执行。 
 *
 *
 *#######自学quartz、juc############
 */
public class TimeScheduleDemo {
	public static void main(String[] args) {
		Timer timer=new Timer();
		timer.schedule(new TimerTask() {
			
			@Override
			public void run() {
				System.out.println("I'm do run");
				
			}
		}, new Date(System.currentTimeMillis()+1000), 200);
	}
}
