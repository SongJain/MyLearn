import java.util.Random;
import java.util.Scanner;
public class GuessNumber{
	public static void main(String[] args){
		Random ran = new Random();
		int i = ran.nextInt(10)+1;
		System.out.println("请猜数字：");
		Scanner sc = new Scanner(System.in);
		while(true){
			int s = sc.nextInt();
			if(s!=i)
			{
				if(s>i)
					System.out.println("猜大了");
				else
					System.out.println("猜小了");
			}
			else
			{
				System.out.println("正确！游戏结束！");
				break;
			}
		}
	}
}