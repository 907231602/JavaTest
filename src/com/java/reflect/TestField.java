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
			//1.获取每个属性的权限修饰符
			int t=j.getModifiers();
			String str1=Modifier.toString(t);
			System.out.println(str1+" ");
			
			//2.获取属性的类型
			Class type=j.getType();
			System.out.println(type.getName()+" ");
			//3.获取属性名
			System.out.println(j.getName());
		}
	}
	
	/**
	 * 运行时类的方法
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
			
			//1.注释
			Annotation[] ann=mm.getAnnotations();
			for(Annotation a:ann){
				System.out.println(a);
			}
			
			//2.权限修饰符
			String str=Modifier.toString(mm.getModifiers());
			System.out.println(str+" ");
			
			//3.返回值类型
			Class returnType=mm.getReturnType();
			System.out.println(returnType.getName());
			
			//4.方法名
			System.out.println(mm.getName());
			
			//5.形参列表
			
			//6.异常类型
		}
	}
	
}
