package com.java.DesignPatterns.FactoryMethod;

public class FactoryTestMore {
	/**
	 * �����������ģʽ
	 * @param args
	 */
	public static void main(String[] args) {
		SendFactoryMore factorymore=new SendFactoryMore();
		Sender sender= factorymore.produceMail();
		sender.Send();
	}
	
	
	
}
