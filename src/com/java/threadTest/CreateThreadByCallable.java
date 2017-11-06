package com.java.threadTest;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/**
 * ʹ��callable�����߳�
 * @author Administrator
 *
 */
public class CreateThreadByCallable {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		/*Callable aa=new Callable<Integer>() {

			@Override
			public Integer call() throws Exception {
				// TODO Auto-generated method stub
				return 11;
			}
		};*/
		//ʹ��Executors�����߳�
	/*	//�����߳�
		ExecutorService exe=Executors.newFixedThreadPool(1);
		Race tortoise=new Race();
		//��ȡֵ
		Future<Integer> result=exe.submit(tortoise);
		int num=result.get();
		System.out.println(num);
		
		exe.shutdownNow();*/
		
		//ʹ��FutureTask�������߳�
		Provide pv=new Provide();
		FutureTask<Integer> ft=new FutureTask<>(pv);
		new Thread(ft).start();
		
		while(!ft.isDone()) {
			System.out.println("������������û...");
            Thread.sleep(1000);
		}
		
		int amount=0;
		amount=ft.get();
		System.out.println("����������,�Ͻ���"+amount);
		
	}

}

class Race implements Callable<Integer>{

	@Override
	public Integer call() throws Exception {
		// TODO Auto-generated method stub
		return 1000;
	}
	
}

class Provide implements Callable<Integer>{
	private int hours=12;
    private int amount;
	@Override
	public Integer call() throws Exception {
		// TODO Auto-generated method stub
		while(hours>0) {
			System.out.println("I'm working......");
            amount ++;
            hours--;
            Thread.sleep(1000);
		}
		return amount;
	}
	
}
