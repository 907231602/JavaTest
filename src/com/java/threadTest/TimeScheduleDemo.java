package com.java.threadTest;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * ����������������
 * 
 * Timer() -----  �������
 * @author Administrator
 * schedule(TimerTask task, Date time) 
          ������ָ����ʱ��ִ��ָ��������
          
  void schedule(TimerTask task, Date firstTime, long period) 
          ����ָ����������ָ����ʱ�俪ʼ�����ظ��Ĺ̶��ӳ�ִ�С� 
 *
 *
 *#######��ѧquartz��juc############
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
