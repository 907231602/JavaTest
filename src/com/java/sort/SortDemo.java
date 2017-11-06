package com.java.sort;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SortDemo {
	int[] array = new int[10];

	/**
	 * ��������
	 */
	public void createData() {

		Random random = new Random();

		for (int i = 0; i < 10; i++) {

			array[i] = random.nextInt(100);// - random.nextInt(100);// ��������������������֤���ɵ������и���

		}

	}

	/**
	 * ֱ�Ӳ�������
	 * 
	 * @param sort
	 */
	public void GoInsertSort(int[] sort) {
		for (int i = 1; i < sort.length; i++) {
			int temp = sort[i];
			for (int j = i - 1; j >= 0 && sort[j] > temp; j--) {
				sort[j + 1] = sort[j];
				sort[j] = temp;
			}
		}

	}

	/**
	 * ���ֲ�������
	 * 
	 * @param sort
	 */
	public void binaryInsertSort(int[] sort) {

		for (int i = 0; i < sort.length; i++) {
			int temp = sort[i];
			int low = 0;
			int high = i - 1;
			while (low <= high) {
				int mid = (low + high) >>> 1;// �൱��mid = (low + high) / 2������Ч�ʻ��Щ

				if (sort[mid] > temp)
					high = mid - 1;
				else
					low = mid + 1;

			}

			for (int j = i; j > low; j--) {
				sort[j] = sort[j - 1];
			}

			if (low != i) {
				sort[low] = temp;
			}

		}
		System.out.println("\n���ֲ������������----------");
		for (int i : sort) {
			System.out.print(i + " ");
		}

	}

	/**
	 * shell����
	 * 
	 * @param sort
	 */
	public void shellSort(int[] sort) {
		int[] a = sort;
		int d = a.length;
		while (true) {
			d = d / 2;
			for (int x = 0; x < d; x++) {
				for (int i = x + d; i < a.length; i = i + d) {
					int temp = a[i];
					int j;
					for (j = i - d; j >= 0 && a[j] > temp; j = j - d) {
						a[j + d] = a[j];
					}
					a[j + d] = temp;
				}
			}
			if (d == 1) {
				break;
			}
		}
		System.out.println("\n shell�����----------");
		for (int i : a) {
			System.out.print(i + " ");
		}

	}

	/**
	 * ��ѡ������
	 * 
	 * @param sort
	 */
	public void SimpleSelectSort(int[] sort) {
		for (int i = 0; i < sort.length; i++) {
			int min = sort[i];
			int minIndex = i;
			for (int j = i + 1; j < sort.length; j++) {
				if (min > sort[j]) {
					min = sort[j];
					minIndex = j;
				}
			}
			sort[minIndex] = sort[i];
			sort[i] = min;
		}
		System.out.println("\n ��ѡ����������ǰ----------");
		for (int i : sort) {
			System.out.print(i + " ");
		}

	}

	/**
	 * ð������
	 * 
	 * @param sort
	 */
	public void bubbleSort(int[] sort) {

		for (int i = 0; i < sort.length; i++) {
			for (int j = 0; j < sort.length - i - 1; j++) {
				if (sort[j] > sort[j + 1]) {
					int temp = sort[j];
					sort[j] = sort[j + 1];
					sort[j + 1] = temp;
				}
			}
		}
		System.out.println("\n ð�������-----------------");
		for (int i : sort) {
			System.out.print(i + " ");
		}

	}

	/**
	 * ��������
	 * 
	 * @param sort
	 * @param low
	 * @param high
	 */
	public void quikSort(int[] sort, int low, int high) {
		if (low < high) {
			int mid = getMid(sort, low, high);
			quikSort(sort, 0, mid - 1);
			quikSort(sort, mid + 1, high);
		}
	}

	public int getMid(int[] sort, int low, int high) {
		int temp = sort[low];
		while (low < high) {
			while (low < high && sort[high] >= temp) {
				high--;
			}
			sort[low] = sort[high];

			while (low < high && sort[low] <= temp) {
				low++;
			}
			sort[high] = sort[low];
		}
		sort[low] = temp;
		return low;
	}

	/**
	 * ��������
	 * 
	 * @param sort
	 */
	public void RadixSort(int[] sort) {
		// �ҵ��������ȷ��Ҫ������
		int max = 0;
		for (int i : sort) {
			if (max < i)
				max = i;
		}
		// �ж�λ��
		int times = 0;
		//max = Math.abs(max);
		while (max > 0) {
			max = max / 10;
			times++;
		}
		System.out.println("time="+times);
		// ����ʮ������
		List<ArrayList> queue = new ArrayList<>();

		for (int i = 0; i < 10; i++) {
			ArrayList<Object> queue1 = new ArrayList<>();
			queue.add(queue1);
		}
		// ����times�η�����ռ�
		for (int i = 0; i < times; i++) {
			// ����
			for (int j = 0; j < sort.length; j++) {
				int num =  (sort[j] % (int)Math.pow(10, i + 1) /(int) Math.pow(10, i));
				ArrayList<Object> queue2 = queue.get(num);
				queue2.add(sort[j]);
				queue.set(num, queue2);

			}
			
			
			int count = 0;
			for (int k = 0; k < 10; k++) {
				while (queue.get(k).size() > 0) {
					//System.out.println(queue.get(k).size()+" "+k+"PP--"+queue.get(k).get(0));
					//queue.get(k).remove(0);
					ArrayList<Integer> queue3 = queue.get(k);
					sort[count] = queue3.get(0);
					queue3.remove(0);
					count++;
				}
			}

		}
		
		

	}

	public static void main(String[] args) {
		SortDemo sortDemo = new SortDemo();
		sortDemo.createData();
		int[] aa = sortDemo.array;
		System.out.println("ֱ�Ӳ�����������ǰ----------");
		for (int array : aa) {
			System.out.print(array + " ");
		}

		sortDemo.GoInsertSort(aa);
		System.out.println("\nֱ�Ӳ������������----------");
		for (int array : aa) {
			System.out.print(array + " ");
		}
		///////////////////////////////////////////////////////////
		sortDemo.createData();
		System.out.println("\n���ֲ�����������ǰ----------");
		for (int array : aa) {
			System.out.print(array + " ");
		}
		sortDemo.binaryInsertSort(aa);
		////////////////////////////////////////////////////////////

		sortDemo.createData();
		System.out.println("\n shell����ǰ----------");
		for (int array : aa) {
			System.out.print(array + " ");
		}
		sortDemo.shellSort(aa);

		//////////////////////////////////////////////////////////////////////
		sortDemo.createData();
		System.out.println("\n ��ѡ����������ǰ----------");
		for (int array : aa) {
			System.out.print(array + " ");
		}
		sortDemo.SimpleSelectSort(aa);

		/////////////////////////////////////////////////////////////
		sortDemo.createData();
		System.out.println("\n ð������ǰ----------");
		for (int array : aa) {
			System.out.print(array + " ");
		}
		sortDemo.bubbleSort(aa);
		///////////////////////////////////////////////////////////////

		sortDemo.createData();
		System.out.println("\n ��������ǰ----------");
		for (int array : aa) {
			System.out.print(array + " ");
		}
		sortDemo.quikSort(aa, 0, aa.length - 1);
		System.out.println("\n ���������-----------------");
		for (int i : aa) {
			System.out.print(i + " ");
		}

		///////////////////////////////////////////////////////////////////////
		//sortDemo.createData();
		 int[] ap={49,38,65,97,176,213,227,49,78,34,12,164,11,18,1};
		System.out.println("\n ��������ǰ-----------");
		for (int i : ap) {
			System.out.print(i + " ");
		}
		sortDemo.RadixSort(ap);
		System.out.println("\n���������");
		for (int i : ap) {
			System.out.println(i+" ");
		}
		

	}

}
