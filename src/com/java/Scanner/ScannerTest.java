package com.java.Scanner;

import java.util.Scanner;

import org.junit.Test;

public class ScannerTest {
	@Test
	public void ScannerTest1(){
		 @SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);  
		  
	        double sum = 0;  
	        int m = 0;  
	  
	        while(scan.hasNextDouble())  
	        {  
	            double x = scan.nextDouble();  
	            m = m + 1;  
	            sum = sum + x;  
	        }  
	  
	        System.out.println(m+"�����ĺ�Ϊ"+sum);  
	        System.out.println(m+"������ƽ��ֵ��"+(sum/m));  
	}
}
