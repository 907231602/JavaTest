package com.java.testPri;

public class TestCalulator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			/*int i=2;
			int j=(i++)+(i++)+(++i);
			System.out.println("i="+i+" j="+j);
			System.out.println(2^3);
			System.out.println(">>>>>>>>>>>>>>>>>>>>");
			 int number = -10;
			          //原始数二进制
			          printInfo(number);
			          number = number << 1;
			          //左移一位
			          printInfo(number);
			          number = number >>> 1;
			          //右移一位
			          printInfo(number);
			          
			  int[][] a= {{1,2,3},{3,2,2},{2,2,2}};
			  int[] aa={};*/
			  
			  int[] a = {129,195,155};
			  int[] b = a;
			  for (int i=0;i<b.length;i++)
			  {
				 // b[i]++;
				  System.out.println(b[i]++);
			  }
			 
			  for (int i=0;i<a.length;i++)
			  System.out.print(a[i]);
			 
	}
	
	 private static void printInfo(int num){
		         System.out.println(Integer.toBinaryString(num));
		      }

}
