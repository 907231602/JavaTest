package com.java.DesignPatterns.FactoryMethod;

public class FactoryTest {
	/**
	 * ��ͨ����ģʽ
	 * @param args
	 */
	public static void main(String[] args) {
		SendFactory factory=new SendFactory();
		Sender sender= factory.produce("sms");
		sender.Send();
	}
	
	
	
}
