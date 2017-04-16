package com.java.DesignPatterns.Prototype;

/**
 * 原型模式
 * 该模式思想：将一个对象作为原型，对其进行复制、克隆，产生一个和原对象类似的新对象
 * @author Administrator
 *
 */
public class PrototypeTest {

	public static void main(String[] args) throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		Prototype proto=new Prototype();
		 Prototype proClone= (Prototype) proto.clone();
		 System.out.println(proClone);
	}

}
