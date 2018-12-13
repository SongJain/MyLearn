package niuke2;

public class helanguoqi {
	
	public static void helan(int[] arr, int num) {
		int left = 0;
		int right = arr.length - 1;
		int less = left - 1;
		int more = right + 1;
		
		while(left < more) {
			if(arr[left] < num) {
				swap(arr,++less, left++);
			}else if(arr[left] > num) {
				swap(arr, --more, left);
			}else {
				left++;
			}
		}
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
	
	public static void main(String[] args) {
		
		int[] res = {0,0,0,0,0,0,0,0,0,0};
 		for(int i = 0; i < 10; i++) {
			int ran = (int) (Math.random()*10 +8) - (int) (Math.random()*10 +2);
			res[i] = ran;
		}
 		printarr(res);
 		System.out.println("num = " + res[3]);
 		helan(res,res[3]);
 		printarr(res);
	}
}
