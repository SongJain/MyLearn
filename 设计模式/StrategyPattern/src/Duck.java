
public abstract class Duck {
	
	QuackBehavior quackBehavior;
	FlyBehavior flyBehavior;
	//还可以定义其他的接口实现更多的变化
	//每一只鸭子都会引用实现这些接口的对象
	
	public Duck() {
		
	}
	
	public abstract void display();		//交给子类覆盖
	
	public void swim() {
		System.out.println("I can swim");
	}
	
	public void performQuack() {
		quackBehavior.quack();		//鸭子对象不亲自处理行为，而是交给实现类。
	}
	
	public void performFly() {
		flyBehavior.fly();			//鸭子对象不亲自处理行为，而是交给实现类。
	}
	
	//set方法,动态设定行为
	public void setFlyBehavior(FlyBehavior fb) {		//这里直接传进一个
		flyBehavior = fb;								//FlyBehavior接口的实现类作为参数		
	}
		
		
	//set方法
	public void setQuackBehavior(QuackBehavior qb) {		//这里直接传进一个
		quackBehavior = qb;								//QuackBehavior接口的实现类作为参数		
	}
	
}
