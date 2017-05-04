package com.java.Scanner;

class Stu{
	@Override
	public boolean equals(Object arg0) {
		// TODO Auto-generated method stub
		return super.equals(arg0);
	}
}

public class DebugExample {
	/*public static int factorial(int value){
		if(value==0){
			return 1;
		}else{
			return value * factorial(value-1);
		}
	}*/
	
	public static void main(String[] args) {
		Integer r1 = new Integer(900);//定义r1整型对象
		Integer r2 = new Integer(900);//定义r2整型对象
		System.out.println(r1==r2);//返回false
		System.out.println(r1.equals(r2));//返回true
		
		Stu s1=new Stu();
		Stu s2=new Stu();
		System.out.println(s1==s2);
		System.out.println(s1.equals(s2));
		/*String s1 = "Monday";
		String s2 = new String("Monday");
		s2 = s2.intern();
		if (s1 == s2)
		{System.out.println("s1 == s2");}
		else
		{System.out.println("s1 != s2");}
		if (s1.equals(s2)) {System.out.println("s1 equals s2");}
		else{
		System.out.println("s1 not equals s2");
		}*/
		}
	
}
