package niuke2;

import java.util.Arrays;

public class QuickSortrandom {

	public static void quickSort(int[] a) {
		if(a.length < 2) {
			return;
		}
		quickSort(a,0,a.length-1);
	}
	
	public static void quickSort(int[] a,int left, int right) {
		if(left < right) {			
			int ran = (int)(Math.random() * (right - left + 1));
			swap(a, left + ran,right);
			int[] num = quicksort(a,left,right);
			quickSort(a, left, num[0] - 1);
			quickSort(a, num[1] + 1, right);
		}
	}
	
	public static int[] quicksort(int[] a,int left, int right) {
		int less = left -1;
		int more = right;
		int num = a[right];
		while(left < more) {
			if(a[left] < num) {
				swap(a, ++less,left++);
			}else if(a[left] > num) {
				swap(a,--more,left);
			}else {
				left++;
			}
		}
		swap(a,right,more);
		return new int[] {less + 1,more};
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
