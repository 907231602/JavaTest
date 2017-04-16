package com.java.DesignPatterns.FactoryMethod;

public class FactoryTestMore {
	/**
	 * 多个工厂方法模式
	 * @param args
	 */
	public static void main(String[] args) {
		SendFactoryMore factorymore=new SendFactoryMore();
		Sender sender= factorymore.produceMail();
		sender.Send();
	}
	
	
	
}
