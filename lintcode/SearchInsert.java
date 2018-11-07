package K;

public class Insert {
	public int searchInsert(int[] A, int target) {
        // write your code here
        int i = 0;
        for(; i < A.length; i++){
            if(target == A[i]){
                return i;
            }
            else if(i >= 1 && A[i] > target && target > A[i-1]){
                return i;
            }
            else if(i == A.length-1 && target > A[i]){
                return i+1;
            }
        }
        return 0;
    }
	
	public static void main(String[] args){
		int[] nums = {2,4,6,1,8};
		Insert i = new Insert();
		int result;
		result = i.searchInsert(nums, 4);
		System.out.println(result);
	}
}
