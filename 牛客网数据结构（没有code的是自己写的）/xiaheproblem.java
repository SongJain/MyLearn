package niuke;

import java.util.Arrays;

public class xiaheproblem {
	
	public static int mergesort(int[] a) {
		if(a.length <= 1)
			return 0;
		return mergesort(a, 0, a.length-1);
	}
	public static int mergesort(int[] a, int lindex, int rindex) {
		if(rindex == lindex)
			return 0;
		int mid = (rindex + lindex)/2;
		mergesort(a, lindex, mid);
		mergesort(a, mid+1 , rindex);
		return mergesort(a, lindex, mid) + merge(a, lindex, mid, rindex) + mergesort(a, mid+1 , rindex);
	}
	public static int merge(int[] arr, int l, int m, int r) {
		int[] help = new int[r - l + 1];
		int i = 0;
		int p1 = l;
		int p2 = m + 1;
		int res = 0;
		while (p1 <= m && p2 <= r) {
			res += arr[p1] < arr[p2] ? (r - p2 + 1) * arr[p1] : 0;
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
		return res;
	}
	//for test
	public static void main(String[] args) {
		
		int re = 0;
		int[] res = {1,2,3,4,5};
 		/*for(int i = 0; i < 5; i++) {
			int ran = (int) (Math.random()*10 +8) - (int) (Math.random()*10 +2);
			res[i] = ran;
			System.out.print(ran + " ");
		}*/
 		re = mergesort(res);
 		System.out.println(re);
	}
}
