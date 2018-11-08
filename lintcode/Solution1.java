package K;

public class Solution1 {
	public long nNumber(long n){//递归求阶乘
        if(n == 1){
            return 1;
        }
        else{
            return n*nNumber(n-1);
        }
    }
	
	public long zeros(long i){//求0出现的个数
        int zero = 0;//0的个数
        for(long j = 10; j < i ; j=j*10){
        	if(i % j ==0) {
        		zero++;
        	}
        }
        return zero;
    }
	
	//升级以后的算法，算5的倍数的个数即可。
	public class Solution {
	    /*
	     * @param n: An integer
	     * @return: An integer, denote the number of trailing zeros in n!
	     */
	    public long trailingZeros(long n) {
	        // write your code here, try to do it without arithmetic operators.
			long count = 0;
	            while (n > 0) {
	                count += (n / 5);
	                n /= 5;
	            }
	            return count;
	    }
	}
	public static void main(String[] args) {
		Solution1 s = new Solution1();
		long k = s.nNumber(26);
		System.out.println(k);		
		long result = s.zeros(k);
		System.out.println(result);
	}
}
