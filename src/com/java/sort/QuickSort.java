package com.java.sort;

//快速排序
public class QuickSort {
	static final int SIZE=18;
	static void quickSort(int[] arr,int left,int right){
		int f,t;
		int rtemp,ltemp;
		
		ltemp=left;
		rtemp=right;
		
		f=arr[(left+right)/2];
		while(ltemp<rtemp){
			while(arr[ltemp]<f){
				++ltemp;
			}
			while(arr[rtemp]>f){
				--rtemp;
			}
			if(ltemp<=rtemp){
				t=arr[ltemp];
				arr[ltemp]=arr[rtemp];
				arr[rtemp]=t;
				--rtemp;
				++ltemp;
			}
			
		}
		if(ltemp==rtemp){
			ltemp++;
		}
		if(left<rtemp){
			quickSort(arr, left, rtemp-1);
		}
		if(ltemp<rtemp){
			quickSort(arr, ltemp+1, right);
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
		
	quickSort(shuzu, 0, SIZE-1);

		System.out.println("排序后：");
		
		for(int k:shuzu){
			System.out.print(k+" ");
		}
		System.out.println();
	}
}
