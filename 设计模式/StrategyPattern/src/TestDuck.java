
public class TestDuck {

	public static void main(String[] args) {
		Duck aduck = new OneDuck();
		
		//最初状态
		aduck.display();
		System.out.println("我是一只鸭子，一开始我是会飞的！");
		aduck.performFly();
		System.out.println("我也是会叫的！");
		aduck.performQuack();
		
		//动态设定行为，使鸭子不会飞
		System.out.println("有一天，我的翅膀折断了，我不会飞了！");
		aduck.setFlyBehavior(new FlyNoWay());
		aduck.performFly();
		
	}
	
}
