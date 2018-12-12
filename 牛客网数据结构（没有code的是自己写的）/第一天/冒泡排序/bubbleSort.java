package niuke;

import java.util.Arrays;

public class bubbleSort {
	
	//冒泡排序，从小到大排序
	public static void bubblesort(int[] arr) {
		if(arr.length <=1)
			return;
		for(int i = 0; i < arr.length-1; i++) {
			for(int j = 0; j < arr.length-i-1; j++) {
				if(arr[j] > arr[j+1]) {
					int tmp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = tmp;
				}
			}
		}
	}
	//打印数组，测试用。
	public static void printarr(int[] arr) {
		for(int i = 0; i <= arr.length-1; i++) {
			System.out.print(arr[i] + "  ");
		}
		System.out.println(" ");
	}
	
	//运用对数器测试冒泡排序，正确打印Nice，错误打印Fucking Fucked。
	public static void main(String[] args) {
		
		int[] res = {0,0,0,0,0,0,0,0,0,0};
		int[] res1 = {0,0,0,0,0,0,0,0,0,0};
 		for(int i = 0; i < 10; i++) {
			int ran = (int) (Math.random()*10 +8) - (int) (Math.random()*10 +2);
			res[i] = ran;
			res1[i] = ran;
		}
		bubblesort(res);
		Arrays.sort(res1);
		if(Arrays.equals(res, res1))
			System.out.println("Nice!");
		else System.out.println("Fucking Fucked");
	}
}
