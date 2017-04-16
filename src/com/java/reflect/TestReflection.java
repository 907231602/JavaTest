package com.java.reflect;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Properties;

import org.junit.Test;

public class TestReflection {

	@Test
	public void test1() throws Exception{
		Class clazz=Person.class;
		//����clazz��Ӧ������ʱ��Person��Ķ���
		Person p=(Person) clazz.newInstance();
		
		//ͨ������
		Field f1=clazz.getField("name");//��ȡ����Ϊpublic������
		f1.set(p,"zhangshao");
		System.out.println(p);
		
		Field f2=clazz.getDeclaredField("age");//��ȡ����Ϊprivate������
		f2.setAccessible(true);
		f2.set(p,20);
		System.out.println(p);
		
		Method m1=clazz.getMethod("show");
		m1.invoke(p);
		
		Method m2=clazz.getMethod("display", String.class);
		m2.invoke(p, "China");
		
	}
	
	/**
	 * ��ȡclassʵ��
	 * @throws ClassNotFoundException 
	 * @throws IOException 
	 */
	@Test
	public void test2() throws ClassNotFoundException, IOException{
		//1.��������ʱ�౾���.class����
		Class clazz1=Person.class;
		System.out.println(clazz1.getName());
		
		Class clazz2=String.class;
		System.out.println(clazz2.getName());
		
		//2.ͨ������ʱ��Ķ����ȡ
		Person p=new Person();
		Class clazz3=p.getClass();
		System.out.println(clazz3);
		
		//3.ͨ��Class�ľ�̬������ȡ
		String className="com.java.reflect.Person";
		Class clazz4=Class.forName(className);
		System.out.println(clazz4);
		
		
		//4.ͨ����ļ�����
		ClassLoader classloader=this.getClass().getClassLoader();
		Class  clazz5=classloader.loadClass(className);
		System.out.println("class5="+clazz5);
		
		//5.��ȡ�����ļ�����
		ClassLoader loader1=this.getClass().getClassLoader();
		InputStream is=loader1.getResourceAsStream("com\\java\\reflect\\jdbc.properties");
		Properties pros=new Properties();
		pros.load(is);
		String Name=pros.getProperty("user");
		String Ps=pros.getProperty("password");
		System.out.println("Name="+Name+",Ps="+Ps);
		
	}
	
	/**
	 * �������
	 */
	@Test
	public void test3(){
		ClassLoader loader1=ClassLoader.getSystemClassLoader();
		System.out.println(loader1);
		
		ClassLoader loader2=loader1.getParent();
		System.out.println(loader2);
		
		ClassLoader loader3=loader2.getParent();
		System.out.println(loader3);
		
		Class<Person> clazz1=Person.class;
		ClassLoader loader4=clazz1.getClassLoader();
		System.out.println(loader4);
		
	}
	
}
