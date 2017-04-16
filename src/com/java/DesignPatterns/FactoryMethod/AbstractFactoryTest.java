package com.java.DesignPatterns.FactoryMethod;

public class AbstractFactoryTest {
	/**
	 * 抽象工厂模式
	 * 该模式好处在于当需要增加新的功能，直接增加新的工厂类就可以，不需要修改之前的代码
	 * @param args
	 */
		public static void main(String[] args) {
			Provider provider=new SendSmsFactory();
			Sender sender =provider.produce();
			sender.Send();
		}
}
