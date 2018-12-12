package niuke;

import java.util.Arrays;

public class chooseSort {
	public static void choosesort(int[] arr) {
		if(arr.length <= 1)
			return;
		int j,i;
		for(i = 0; i <= arr.length-1; i++) {
			int maxindex = i;
			for(j = i+1; j <= arr.length-1; j++) {
				if(arr[j] < arr[maxindex]) {
					int tmp = arr[j];
					arr[j] = arr[maxindex];
					arr[maxindex] = tmp;
				}	
			}			
		}
	}
	
	public static void printarr(int[] arr) {
		for(int i = 0; i <= arr.length-1; i++) {
			System.out.print(arr[i] + "  ");
		}
		System.out.println(" ");
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
		//printarr(res1);
 		choosesort(res);
 		//printarr(res);
 		if(Arrays.equals(res, res1))
			System.out.println("Nice!");
		else System.out.println("Fucking Fucked");
	}
}