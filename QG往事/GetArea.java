import java.util.Scanner;
public class GetArea{
	public static int getArea(int w,int h){
		return w*h;
	}
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入长：");
		int i = sc.nextInt();
		System.out.println("请输入宽：");
		int j = sc.nextInt();
		int answer;
		answer = getArea(i,j);
		System.out.println("面积为："+answer);
	}
}