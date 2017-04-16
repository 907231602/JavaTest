package com.java.DesignPatterns.FactoryMethod;

public class FactoryTest {
	/**
	 * 普通工厂模式
	 * @param args
	 */
	public static void main(String[] args) {
		SendFactory factory=new SendFactory();
		Sender sender= factory.produce("sms");
		sender.Send();
	}
	
	
	
}
