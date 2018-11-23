
public class OneDuck extends Duck{
	
	public OneDuck() {
		quackBehavior = new Quack();			//这里使用构造器来构造鸭子的行为											
		flyBehavior = new FlyWithSwings();		
	}
	
	
	public void display() {
		System.out.println("I am a real duck!");
	}

}
