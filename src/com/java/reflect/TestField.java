package com.java.reflect;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import org.junit.Test;

public class TestField {
	@Test
	public void test1(){
		Class clazz=Person.class;
		
		Field[] fields=clazz.getFields();
		/*for(int i=0;i<fields.length;i++){
			System.out.println(fields[i]);
		}*/
		/*for(Field i:fields){
			System.out.println("hello"+i);
		}*/
		
		Field[] field2=clazz.getDeclaredFields();
		for(Field j:field2){
			System.out.println(j);
			//1.��ȡÿ�����Ե�Ȩ�����η�
			int t=j.getModifiers();
			String str1=Modifier.toString(t);
			System.out.println(str1+" ");
			
			//2.��ȡ���Ե�����
			Class type=j.getType();
			System.out.println(type.getName()+" ");
			//3.��ȡ������
			System.out.println(j.getName());
		}
	}
	
	/**
	 * ����ʱ��ķ���
	 */
	@Test
	public void test2(){
		Class clazz=Person.class;
		Method[] m1=clazz.getMethods();
		for(Method m:m1){
			System.out.println(m);
		}
		
		System.out.println();
		
		Method[] m2=clazz.getDeclaredMethods();
		for(Method mm:m2){
			System.out.println(mm);
		}
		
	}
	
	@Test
	public void test3(){
		Class clazz=Person.class;
		Method[] m2=clazz.getDeclaredMethods();
		for(Method mm:m2){
			System.out.println(mm);
			
			//1.ע��
			Annotation[] ann=mm.getAnnotations();
			for(Annotation a:ann){
				System.out.println(a);
			}
			
			//2.Ȩ�����η�
			String str=Modifier.toString(mm.getModifiers());
			System.out.println(str+" ");
			
			//3.����ֵ����
			Class returnType=mm.getReturnType();
			System.out.println(returnType.getName());
			
			//4.������
			System.out.println(mm.getName());
			
			//5.�β��б�
			
			//6.�쳣����
		}
	}
	
}
