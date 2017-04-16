package com.java.pack;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class ForTest {
	public static void main(String[] args)  
    {  
		 long t1,t2;
		int[] integers = {1,2, 3, 4};
		 /* ��ʼ���� */
		  t1=System.currentTimeMillis(); 
		 for (int j = 0; j < integers.length; j++) {
		     int i = integers[j];
		     System.out.print(" i="+i+";");
		 } 
		 t2=System.currentTimeMillis();  
	        System.out.println("Run Time:" + (t2 -t1) + "(ms)");  
		 
		 System.out.println();
		 String[] strings = {"A", "B", "C", "D"};
		 Collection<String> stringList = java.util.Arrays.asList(strings);
		 /* ��ʼ���� */
		 for (Iterator<String> itr = stringList.iterator(); itr.hasNext();) {
		     Object str = itr.next();
		     System.out.print(" str="+str+";");
		 }
		 
		 int[] integerss = {11, 22, 33, 44};

		 /* ��ʼ���� */
		 t1=System.currentTimeMillis(); 
		 for (int i : integerss) {
		     System.out.println(" i="+i+";"); /* ���������1������2������3������4�� */
		 }
		 t2=System.currentTimeMillis();  
	        System.out.println("Run Time:" + (t2 -t1) + "(ms)");  
	        
	        List<String> list = new ArrayList<String>();  
	        list.add("java111");  
	        list.add("java222");  
	        list.add("java333");  
	        list.add("java444");  
	        list.add("java555");  
	  
	        // ������ʽ1 ��ʹ��iterator  
	        Iterator<String> it = list.iterator();  
	        while (it.hasNext()) {  
	            String value = it.next();  
	            System.out.println(value);  
	        }  
	  
	        // ��������2 �� ʹ�ô�ͳforѭ�����б�����  
	        for (int i = 0, size = list.size(); i < size; i++) {  
	            String value = list.get(i);  
	            System.out.println(value);  
	        }  
	  
	        // ��������3 �� ʹ����ǿforѭ�����б�����  
	        for (String value : list) {  
	            System.out.println(value);  
	        }  
    }  
}
