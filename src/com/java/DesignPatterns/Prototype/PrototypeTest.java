package com.java.DesignPatterns.Prototype;

/**
 * ԭ��ģʽ
 * ��ģʽ˼�룺��һ��������Ϊԭ�ͣ�������и��ơ���¡������һ����ԭ�������Ƶ��¶���
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
