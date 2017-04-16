package com.java.sort;

/**
 * 选择排序
 * @author Administrator
 *
 */
public class SelectSort
{
	int SIZE=10;
	public void selectSort(int[] a)
	{
		int index,temp;
		for(int i=0;i<a.length-1;i++)
		{
			index=i;
			for(int j=i+1;j<a.length;j++)
			{
				if(a[j]<a[index]){
					index=j;
				}
			}
			if(index!=i){
				temp=a[i];
				a[i]=a[index];
				a[index]=temp;
			}
			System.out.println("第"+i+"步排序结果");
			
			for(int k:a){
				System.out.print(k+" ");
			}
			System.out.println();
			
		}
	}
	
	public static void main(String[] args) {
		SelectSort ss=new SelectSort();
		int[] shuzu=new int[ss.SIZE];
		int i;
		for(i=0;i<ss.SIZE;i++){
			shuzu[i]=(int) (Math.random()*(100+1));
		}
		
		System.out.println("排序前");
		for(int h:shuzu){
			System.out.println(h+" ");
		}
		
		ss.selectSort(shuzu);
		
		System.out.println("排序后");
		for(int h:shuzu){
			System.out.println(h+" ");
		}
		
	}
	
}
