package com.java.annotation;
//ע��
/**
 * JDk�ṩ�ĳ���ע��
 * @Override:�޶���д���෽����ֻ���ڷ���
 * @Deprecated:���ڱ�ʾĳ������Ԫ�أ��ࡢ�����ȣ��ѹ�ʱ
 * @SuppressWarnings�����Ʊ���������
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
		System.out.println("ѧ����·");
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
		System.out.println("����·");
	}
	@Deprecated
	public void eat(){
		System.out.println("�˳Զ���");
	}
}
