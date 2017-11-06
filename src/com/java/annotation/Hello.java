package com.java.annotation;


class A{
	static {
		System.out.println("1");
	}
	public A() {
		// TODO Auto-generated constructor stub
		System.out.println("A");
	}
}

class B extends A{
	static {
		System.out.println("2 fuck you mather !!!");
		
	}
	{
		System.out.println("d");
	}
	
	public B() {
		// TODO Auto-generated constructor stub
		System.out.println("B");
	}
}

public class Hello {
	public static void main(String[] args) {
		A a=new B();
		a=new B();
	}
	
}
