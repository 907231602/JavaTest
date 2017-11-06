package com.java.IOTest;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * 序列化     
 * 反序列化
 * @author Administrator
 *
 */
public class ObjectSeriDemo {
	
	//将对象写入到文件中
	public void objectWrtieToFile(String fileName) throws FileNotFoundException, IOException {
		File file =new File(fileName);
		
		Emp emp=new Emp();
		emp.setSalary(222);
		emp.setAge(22);
		emp.setInfo("北疆");
		
		ObjectOutputStream oos=new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(file)));
		oos.writeObject(emp);
		oos.close();
		
		
	}
	
	public void objectReadFromFile(String fileName) throws Exception {
		File file=new File(fileName);
		
		ObjectInputStream ois=new ObjectInputStream(new BufferedInputStream(new FileInputStream(file)));
		
		Object obj= ois.readObject();
		Emp emp=null;
		if(obj instanceof Emp)
			emp= (Emp)obj;
		System.out.println(emp);
		ois.close();
		
	}
	
	public static void main(String[] args) throws Exception {
		ObjectSeriDemo osd=new ObjectSeriDemo();
		//osd.objectWrtieToFile("file"+File.separator+"objectData.txt");
		//osd.objectReadFromFile("file"+File.separator+"objectData.txt");
		//FileInputStream fis=null;
		//测试try-with-resource
		try(FileInputStream fis=new FileInputStream(new File("file"+File.separator+"fileOut.txt"))) {
			
				//fis=new FileInputStream(new File("file"+File.separator+"fileOut.txt"));
			byte[] b=new byte[1024];
			while(fis.read(b)!=-1) {
				System.out.println(new String(b));
			
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
	
	

}

class Emp implements Serializable{
	//使用transient（透明）可以不会被序列化
	public  int salary;
	public transient int age;
	public String info;
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	@Override
	public String toString() {
		return "Emp [salary=" + salary + ", age=" + age + ", info=" + info + "]";
	}
}
