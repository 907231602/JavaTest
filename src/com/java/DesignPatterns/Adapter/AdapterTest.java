package com.java.DesignPatterns.Adapter;

/**
 * ���������ģʽ
 * @author Administrator
 *
 */
public class AdapterTest {
	public static void main(String[] args) {
		Targetable target=new Adapter();
		target.method1();
		target.method2();
	}
}
