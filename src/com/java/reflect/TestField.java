package com.java.reflect;

import java.lang.annotation.Annotation;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import org.junit.Test;

public class TestField {
	@Test
	public void test1(){
		Class<Person> clazz=Person.class;
		
		@SuppressWarnings("unused")
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
			Class<?> type=j.getType();
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
		Class<Person> clazz=Person.class;
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
		Class<Person> clazz=Person.class;
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
			Class<?> returnType=mm.getReturnType();
			System.out.println(returnType.getName());
			
			//4.方法名
			System.out.println(mm.getName());
			
			//5.形参列表
			
			//6.异常类型
		}
	}
	
	
	//
	@Test
	public void testPerson() throws Exception {
		Class<Person> p=Person.class;
		
	  Field[] f =	p.getDeclaredFields();
	  for (Field field : f) {
		System.out.println(field);
	  }
	  
	  Field flectage=p.getDeclaredField("age");
	  Person person =p.newInstance();
	 // System.out.println("===="+flectage.get(p));	
	  
	  flectage.setAccessible(true);
	  flectage.set(person, 20);

	  System.out.println(person);
	  
	  
	  Constructor<?>[] cons= p.getConstructors();
	 Constructor<?> cc=  p.getConstructor(new Class[] {});
	  for (Constructor<?> constructor : cons) {
		System.out.println("-->"+constructor);
	}
	  System.out.println(cc.toString());
	  
	}
	
	//copy对象
	@Test
	public void testCopy() throws Exception {
		Person p=new Person("Heloo",20);
		
		Person copyP= (Person) copyObjectByClass(p);
		System.out.println(copyP.getAge()+" "+copyP.getName());
		
	}
	
	public Object copyObjectByClass(Object obj) throws Exception {
		Class classType=obj.getClass();
		if(obj instanceof Person) {
			Person p=(Person) obj;
			System.out.println(p.getAge()+"??"+p.getName());
		}
		
		Object classCopy=classType.getConstructor(new Class[] {}).newInstance(new Object[] {});
		
		
		Field[] fields= classType.getDeclaredFields();
		for (Field field : fields) {
			System.out.println("-->"+field.toString());
			String fieldName=field.getName();
			
			String upFirstName=fieldName.substring(0, 1).toUpperCase();
			String setFieldName="set"+upFirstName+fieldName.substring(1);
			String getFieldName="get"+upFirstName+fieldName.substring(1);
			
			Method getMethod= classType.getMethod(getFieldName, new Class[] {});
			Method setMethod= classType.getMethod(setFieldName, new Class[] {field.getType()});
			
			Object value= getMethod.invoke(classCopy, new Object[] {});
			System.out.println(fieldName+"-"+value);
			setMethod.invoke(classCopy, new Object[] {value});
		}
		
		return classCopy;
	}
	
	
	@Test
	public void testArray() throws ClassNotFoundException {
		Class classString=Class.forName("java.lang.String");
		Object array=Array.newInstance(classString, 10);
		Array.set(array, 2, "hello");
		
		System.out.println(Array.get(array, 2));
		
		
		
		
	}
	
	
	
	
}
