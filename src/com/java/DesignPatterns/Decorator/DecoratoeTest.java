package com.java.DesignPatterns.Decorator;

import org.junit.Test;

public class DecoratoeTest {
	
	@Test
	public  void test() {
		Source s=new Source();
		Decorator d=new Decorator(s);
		d.menthd1();
	}

}
