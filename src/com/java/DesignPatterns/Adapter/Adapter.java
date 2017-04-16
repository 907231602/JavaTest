package com.java.DesignPatterns.Adapter;

public class Adapter extends Source implements Targetable {

	@Override
	public void method2() {
		// TODO Auto-generated method stub
		System.out.println("this is targetable method");
	}

}
