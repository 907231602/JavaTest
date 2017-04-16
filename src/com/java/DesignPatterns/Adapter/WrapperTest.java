package com.java.DesignPatterns.Adapter;

/**
 * 对象的适配器模式
 * @author Administrator
 *
 */
public class WrapperTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Source source=new Source();
		Targetable target=new Wrapper(source);
		target.method1();
		target.method2();
	}

}
