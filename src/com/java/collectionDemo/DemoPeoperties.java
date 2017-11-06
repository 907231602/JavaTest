package com.java.collectionDemo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class DemoPeoperties {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//继承自 HashTable
		Properties pro=new Properties();
		pro.setProperty("name", "jack");
		pro.setProperty("age", "23");
		pro.setProperty("where", "byteToSome");
		
		System.out.println(pro.getProperty("age"));	
		try {
			pro.store(new FileOutputStream(new File("person.properties")), "Person");//(new FileInputStream(new File("person.properties")));
			//pro.storeToXML(new FileOutputStream(new File("person.xml")), "persons");
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Fa fa=new Fa();
		Fa.son s= fa.new son();
		s.say();

	}

}

class Fa
{
	
	int type;
	class son{
		String type;
		public void say() {
			System.out.println(son.this);
		}
	}
}
