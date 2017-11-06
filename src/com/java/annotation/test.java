package com.java.annotation;

public class test {
	public static int add(int a) {
		return ++a;
	}
	
	public static void main(String[] args) {
		Integer a=2;
		int b=add(a);
		System.out.println(a+" "+b);
	}

}
