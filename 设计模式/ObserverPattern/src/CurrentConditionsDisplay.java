
public class CurrentConditionsDisplay implements Observer, DisplayElement {
	//这个是三个布告板的其中之一，也就是其中一个观察者
	
	private float temperature;
	private float humidity;
	private Subject weatherData;
	
	//这里传入Subject类的对象作为注册使用
	public CurrentConditionsDisplay(Subject weatherData) {
		this.weatherData = weatherData;
		weatherData.registerObserver(this);
	}
	
	public void update(float temperature, float humidity, float pressure) {
		this.temperature = temperature;
		this.humidity = humidity;
		display();
	}

	//display展示在布告板中
	public void display() {
		System.out.println("Current Conditions :" + temperature + "F degrees"
				+ " and " + humidity + "% humidity");
	}

}
