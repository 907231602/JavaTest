package com.java.DesignPatterns.Prototype;

import java.io.IOException;

import org.junit.Test;

public class StudentTest {
	
	@Test
	public void testStu() throws CloneNotSupportedException {
		Student s=new Student();
		s.setName("hell");
		s.setAge(12);
		School c=new School();
		c.setSchoolName("北方");
		c.setAddress("1026");
		s.setSchool(c);
		Student sClone= s.cloneStu();
		
		sClone.setAge(32);
		sClone.getSchool().setSchoolName("lal");
		System.out.println(sClone);
		System.out.println(s);
		System.out.println(s==sClone);
	}
	
	@Test
	public void deepClone() throws IOException, ClassNotFoundException {
		
		Student s=new Student();
		s.setName("hell");
		s.setAge(12);
		School c=new School();
		c.setSchoolName("北方");
		c.setAddress("1026");
		s.setSchool(c);
		
		Student cloS= s.deepClones();
		cloS.setAge(32);
		cloS.getSchool().setAddress("ppp");
		
		System.out.println(s);
		System.out.println(cloS);
		
	}

}
