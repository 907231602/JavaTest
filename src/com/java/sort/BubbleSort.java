package com.java.sort;


/**
 * ð������
 * @author Administrator
 *
 */
public class BubbleSort {
	static final int SIZE=10;
	public static void bubbleSort(int[] a)
	{
		int temp;
		for(int i=1;i<a.length;i++)
		{
			for(int j=0;j<a.length-i;j++)
			{
				if(a[j]>a[j+1]){
					temp=a[j];
					a[j]=a[j+1];
					a[j+1]=temp;
				}
			}
			System.out.println("��"+i+"��������");
			for(int k:a)
			{
				System.out.print(" "+k);
			}
			System.out.println();
			
		}
	} 
	
	public static void main(String[] args) 
	{
		int[] shuzu=new int[SIZE];
		int i;
		
		for(i=0;i<SIZE;i++)
		{
			shuzu[i]=(int)((100+Math.random()*(100+1)));
		}
		System.out.println("����ǰ������Ϊ");
		for(int d:shuzu){
			System.out.println(d+" ");
		}
		System.out.println();
		bubbleSort(shuzu);
		
		System.out.println("����������Ϊ");
		
		for(int p:shuzu)
		{
			System.out.println(p+" ");
		}
		
	}
	
} 
