package niuke2;

import java.util.Arrays;

public class QuickSort {

	public static void quickSort(int[] arr) {
		if(arr.length <= 1)
			return;
		quicksort(arr, 0, arr.length-1);
	}
	
	public static void quicksort(int[] arr, int left, int right) {
		if(left < right) {
			int p = quickSort(arr,left,right);
			quicksort(arr, left, p-1);
			quicksort(arr, p+1, right);
		}
	}
	
	public static int quickSort(int[] arr, int left, int right) {
		if(left >= right)
			return 0;
		int num = arr[right];
		int less = left - 1;
		int more = right;
		while(left < more) {
			if(arr[left] < num) {
			swap(arr,++less,left++);
			}else if(arr[left] > num) {
				swap(arr,--more,left);
			}else {
				left++;
			}
		}
		swap(arr,more,right);
		return left;
	}
	
	//交换元素
	public static void swap(int[] arr, int index1, int index2) {
		int tmp = arr[index1];
		arr[index1] = arr[index2];
		arr[index2] = tmp;
	}
			
	//打印数组，测试用。
	public static void printarr(int[] arr) {
		for(int i = 0; i <= arr.length-1; i++) {
			System.out.print(arr[i] + "  ");
		}
		System.out.println(" ");
	}	
	
	//比较数组，测试用。
	public static void Compare(int[] a1, int[] a2) {
		if(Arrays.equals(a1, a2)) {
			System.out.println("Nice!");
		}else {
			System.out.println("Fucking Fucked!");
		}
	}
	
	public static void main(String[] args) {
		
		int[] res = {0,0,0,0,0,0,0,0,0,0};
		int[] res1 = {0,0,0,0,0,0,0,0,0,0};
 		for(int i = 0; i < 10; i++) {
			int ran = (int) (Math.random()*10 +8) - (int) (Math.random()*10 +2);
			res[i] = ran;
			res1[i] = ran;
		}
 		Arrays.sort(res1);
 		quickSort(res);
 		Compare(res, res1);
	}
}
