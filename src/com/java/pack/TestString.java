package com.java.pack;

public class TestString {
	static int a=10;
	public static void main(String[] args) {
		int a=0;
		Changer c = new Changer();

		c.method(args);

		System.out.println(args[0] + " "+ args[1]);
		//System.out.println(args[0]);
	}
	
	static class Changer {

		void method(String[] s) {

		String temp = s[0];

		s[0] = s[1];

		s[1] = temp;

		}

		}
}
