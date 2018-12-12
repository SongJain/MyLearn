package niuke;

import java.util.Arrays;

public class mergeSort {
	
	public static void Mergesort(int[] arr) {
		if(arr.length <=1) {
			return;
		}
		Mergesort(arr,0,arr.length-1);
	}
	
	public static void Mergesort(int[] arr,int lindex,int rindex) {
		if(lindex == rindex) {
			return;
		}
		int middle = (rindex + lindex)/2;
		Mergesort(arr,lindex,middle);
		Mergesort(arr,middle+1,rindex);
		merge(arr,lindex,middle,rindex);
	}
	
	public static void merge(int[] arr, int l, int m, int r) {
		int[] help = new int[r - l + 1];
		int i = 0;
		int p1 = l;
		int p2 = m + 1;
		while (p1 <= m && p2 <= r) {
			help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
		}
		while (p1 <= m) {
			help[i++] = arr[p1++];
		}
		while (p2 <= r) {
			help[i++] = arr[p2++];
		}
		for (i = 0; i < help.length; i++) {
			arr[l + i] = help[i];
		}
	}
	
	//for test
		public static void printarr(int[] arr) {
			for(int i = 0; i <= arr.length-1; i++) {
				System.out.print(arr[i] + "  ");
			}
			System.out.println(" ");
		}
		//for test
		public static void main(String[] args) {
			
			int[] res = {0,0,0,0,0,0,0,0,0,0};
			int[] res1 = {0,0,0,0,0,0,0,0,0,0};
	 		for(int i = 0; i < 10; i++) {
				int ran = (int) (Math.random()*10 +8) - (int) (Math.random()*10 +2);
				res[i] = ran;
				res1[i] = ran;
			}
			Arrays.sort(res1);
			printarr(res1);
			Mergesort(res);
	 		printarr(res);
	 		if(Arrays.equals(res, res1))
				System.out.println("Nice!");
			else System.out.println("Fucking Fucked");
		}
}