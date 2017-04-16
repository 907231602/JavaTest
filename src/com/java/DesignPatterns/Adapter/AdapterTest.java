package com.java.DesignPatterns.Adapter;

/**
 * 类的适配器模式
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
