package com.java.DesignPatterns.FactoryMethod;

public class SendFactoryMore {
	/**
	 * �����������ģʽ
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
