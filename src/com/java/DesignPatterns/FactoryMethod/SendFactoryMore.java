package com.java.DesignPatterns.FactoryMethod;

public class SendFactoryMore {
	/**
	 * 多个工厂方法模式
	 * @param type
	 * @return
	 */
		public Sender produceMail(){
			return new MailSender();
		}
		
		public Sender produceSms(){
			return new SmsSender();
		}
}
