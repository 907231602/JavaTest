package com.java.sort;

public class InsertionSort {
	
	/**
	 * ���������㷨
	 */
	static final int SIZE=10;
	
	static void insertionSort(int[] a){
		int i,j,t,h;
		for(i=1;i<a.length;i++){
			t=a[i];
			j=i-1;
			while(j>=0&& t<a[j]){
				a[j+1]=a[j];
				j--;
			}
			a[j+1]=t;
			System.out.print("��"+i+"��������");
			
			for(h=0;h<a.length;h++){
				System.out.print(" " +a[h]);
			}
			System.out.println();
			
		}
	}
	
	public static void main(String[] args) {
		int[] shuzu=new int[SIZE];
		int i;
		for(i=0;i<SIZE;i++){
			shuzu[i]=(int) (100+Math.random()*100+1);
		}
		System.out.println("��������ǰΪ");
		
		for(int d:shuzu){
			System.out.print(d+" ");
		}
		System.out.println();
		
		insertionSort(shuzu);
		
		System.out.println("���������飺");
		
		for(int b:shuzu){
			System.out.print(b+" ");
		}
		System.out.println();
		
	}
}
