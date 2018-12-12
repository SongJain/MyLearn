package niuke;

import java.util.Arrays;

public class insertSort {

	//插入排序，i是被比较的。
	public static void insertsort(int[] arr) {
		if(arr.length <= 1)
			return;
		for(int i = 1; i <= arr.length-1; i++) {
			for(int j = i-1; j >=0 && arr[j] > arr[j + 1]; j--) {
				int tmp = arr[j];
				arr[j] = arr[j+1];
				arr[j+1] = tmp;
			}
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
		insertsort(res);
 		printarr(res);
 		if(Arrays.equals(res, res1))
			System.out.println("Nice!");
		else System.out.println("Fucking Fucked");
	}
}