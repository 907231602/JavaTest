package com.java.DesignPatterns.TemplateMethod;

import org.junit.Test;

public class TemplateTest {

	@Test
	public void testAdd() {
		String exp = "8+8";
		AbstractCalculator cal = new Plus();
		int result = cal.calculate(exp, "\\+");
		System.out.println(result);
		/////////////////////
		String exp1 = "9-8";
		AbstractCalculator cal1 = new Minus();
		int result1 = cal1.calculate(exp1, "\\-");
		System.out.println(result1);
	}
}
