package com.java.threadTest;

/**
 * 生产者消费者问题
 * @author Administrator
 *
 */
class Resource { // 生产者和消费者都要操作的资源
	private String name;
	private int count = 1;
	private boolean flag = false;
	
	//生产
	public synchronized void set(String name) {
		if (flag)
			try {
				wait();
			} catch (Exception e) {
			}
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.name = name + "---" + count++;
		System.out.println(Thread.currentThread().getName() + "...生产者..." + this.name);
		flag = true;
		this.notify();
	}

	//消费
	public synchronized void out() {
		if (!flag)
			try {
				wait();
			} catch (Exception e) {
			}
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + "...消费者..." + this.name);
		flag = false;
		this.notify();
	}
}

class Producer implements Runnable {
	private Resource res;

	Producer(Resource res) {
		this.res = res;
	}

	public void run() {
		while (true) {
			res.set("商品");
		}
	}
}

class Consumer implements Runnable {
	private Resource res;

	Consumer(Resource res) {
		this.res = res;
	}

	public void run() {
		while (true) {
			res.out();
		}
	}
}

public class ProducerConsumerDemo {
	public static void main(String[] args) {
		Resource r = new Resource();
		Producer pro = new Producer(r);
		Consumer con = new Consumer(r);
		Thread t1 = new Thread(pro);
		Thread t2 = new Thread(con);
		t1.start();
		t2.start();
	}
}// 运行结果正常，生产者生产一个商品，紧接着消费者消费一个商品。
