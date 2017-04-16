package com.java.annotation;
//注解
/**
 * JDk提供的常用注解
 * @Override:限定重写父类方法，只用于方法
 * @Deprecated:用于表示某个程序元素（类、方法等）已过时
 * @SuppressWarnings：抑制编译器警告
 * 
 * @author Administrator
 *
 */

public class TestAnnotation {
	public static void main(String[] args) {
		Person p=new Student();
		p.walk();
		p.eat();
	}
}

class Student extends Person{
	@Override
	public void walk(){
		System.out.println("学生走路");
	}
}

class Person{
	String name;
	String age;
	
	public Person(String name, String age) {
		super();
		this.name = name;
		this.age = age;
	}

	public Person() {
		super();
	}
	
	public void walk(){
		System.out.println("人走路");
	}
	@Deprecated
	public void eat(){
		System.out.println("人吃东西");
	}
}
