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
		 /* 开始遍历 */
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
		 /* 开始遍历 */
		 for (Iterator<String> itr = stringList.iterator(); itr.hasNext();) {
		     Object str = itr.next();
		     System.out.print(" str="+str+";");
		 }
		 
		 int[] integerss = {11, 22, 33, 44};

		 /* 开始遍历 */
		 t1=System.currentTimeMillis(); 
		 for (int i : integerss) {
		     System.out.println(" i="+i+";"); /* 依次输出“1”、“2”、“3”、“4” */
		 }
		 t2=System.currentTimeMillis();  
	        System.out.println("Run Time:" + (t2 -t1) + "(ms)");  
	        
	        List<String> list = new ArrayList<String>();  
	        list.add("java111");  
	        list.add("java222");  
	        list.add("java333");  
	        list.add("java444");  
	        list.add("java555");  
	  
	        // 遍历方式1 ，使用iterator  
	        Iterator<String> it = list.iterator();  
	        while (it.hasNext()) {  
	            String value = it.next();  
	            System.out.println(value);  
	        }  
	  
	        // 遍历方法2 ， 使用传统for循环进行遍历。  
	        for (int i = 0, size = list.size(); i < size; i++) {  
	            String value = list.get(i);  
	            System.out.println(value);  
	        }  
	  
	        // 遍历方法3 ， 使用增强for循环进行遍历。  
	        for (String value : list) {  
	            System.out.println(value);  
	        }  
    }  
}
