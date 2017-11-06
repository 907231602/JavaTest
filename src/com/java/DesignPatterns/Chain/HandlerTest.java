package com.java.DesignPatterns.Chain;

import org.junit.Test;

public class HandlerTest {

	@Test
	public void test() {
		MyHandler myHandler1=new MyHandler("m1");
		MyHandler myHandler2=new MyHandler("m2");
		MyHandler myHandler3=new MyHandler("m3");
		
		myHandler1.setHandler(myHandler2);
		myHandler2.setHandler(myHandler3);
		
		myHandler1.operator();
		
	}
	
	
	
}
