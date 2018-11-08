package K;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int test = 564;
		int output;
		Solution s = new Solution();
		output = s.reverseInteger(test);
		System.out.println(output);
	}
	
	public int reverseInteger(int number) {
        // write your code here
        int num1 = number / 100;
        int num2 = (number - (num1*100)) / 10;
        int num3 = (number - (num1 * 100) - (num2 * 10));
        if(num3 == 0 && num2 != 0){
            return num2*10 + num1;
        }
        if(num3 == 0 && num2 == 0){
            return num1;
        }
        return  num3*100 + num2*10 + num1;
    }
}
