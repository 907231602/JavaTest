package com.java.sort;

public class ShellSort {
	static final int SIZE=10;
	
	/**
	 * shell排序
	 * @param a
	 */
	static void shellSort(int[] a){
		int i,j;
		int r,temp;
		int x=0;
		
		for(r=a.length/2;r>=1;r/=2){
			for(i=r;i<a.length;i++){
				temp=a[i];
				j=i-r;
				while(j>=0 && temp<a[j]){
					a[j+r]=a[j];
					j-=r;
				}
				a[j+r]=temp;
			}
			
			x++;
			System.out.print("第"+x+"步排序结果");
			
			for(int f:a){
				System.out.print(" "+f);
			}
			System.out.println();
			
		}
		
	}
	
		public static void main(String[] args) {
			int[] shuzu=new int[SIZE];
			int i;
			for(i=0;i<SIZE;i++){
				shuzu[i]=(int) (100+Math.random()*(100+1));
			}
			
			System.out.println("排序前");
			for(int h:shuzu){
				System.out.print(h+" ");
			}
			System.out.println();
			
			shellSort(shuzu);

			System.out.println("排序后：");
			
			for(int k:shuzu){
				System.out.print(k+" ");
			}
			System.out.println();
		}
}
