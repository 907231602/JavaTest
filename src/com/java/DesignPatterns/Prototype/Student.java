package com.java.DesignPatterns.Prototype;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Student implements Cloneable,Serializable{

	private String name;
	private int age;
	private School school;
	
	public Student cloneStu() throws CloneNotSupportedException {
		//return (Student) super.clone();
		Student s=(Student) super.clone();
		s.school=school.CloneSchool();
		return s;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	
	public School getSchool() {
		return school;
	}

	public void setSchool(School school) {
		this.school = school;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + ", school=" + school + "]";
	}
	
	public Student deepClones() throws IOException, ClassNotFoundException {
		/*ByteArrayOutputStream baot=new ByteArrayOutputStream();
		ObjectOutputStream oos=new ObjectOutputStream(baot);
		oos.writeObject(this);
		ByteArrayInputStream bais=new ByteArrayInputStream(baot.toByteArray());
		ObjectInputStream ois=new ObjectInputStream(bais);
		Student s= (Student) ois.readObject();
		return s;*/
		ByteArrayOutputStream bo=new ByteArrayOutputStream();
		ObjectOutputStream oo=new ObjectOutputStream(bo);
		oo.writeObject(this);//从流里读出来
		ByteArrayInputStream bi=new ByteArrayInputStream(bo.toByteArray());
		ObjectInputStream oi=new ObjectInputStream(bi);
		return (Student) (oi.readObject());
	}
}
