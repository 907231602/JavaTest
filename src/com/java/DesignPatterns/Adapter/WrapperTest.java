package com.java.DesignPatterns.Adapter;

/**
 * �����������ģʽ
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
