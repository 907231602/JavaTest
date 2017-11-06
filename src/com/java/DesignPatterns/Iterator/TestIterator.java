package com.java.DesignPatterns.Iterator;

import org.junit.Test;

public class TestIterator {
	
	@Test
	public void test() {
		  Collection collection = new MyCollection();  
	        Iterator it = collection.iterator();  
	          
	        while(it.hasNext()){  
	            System.out.println(it.next());  
	        }  
	}

}
