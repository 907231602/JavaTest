package com.java.DesignPatterns.FactoryMethod;

public class AbstractFactoryTest {
	/**
	 * ���󹤳�ģʽ
	 * ��ģʽ�ô����ڵ���Ҫ�����µĹ��ܣ�ֱ�������µĹ�����Ϳ��ԣ�����Ҫ�޸�֮ǰ�Ĵ���
	 * @param args
	 */
		public static void main(String[] args) {
			Provider provider=new SendSmsFactory();
			Sender sender =provider.produce();
			sender.Send();
		}
}
