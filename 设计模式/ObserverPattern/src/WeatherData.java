import java.util.ArrayList;

/*
 * WeatherData实现了Subject接口
 * */
public class WeatherData implements Subject {
	
	private ArrayList<Observer> observers;
	private float temperature;
	private float humidity;
	private float pressure;
	
	public WeatherData() {
		observers = new ArrayList<Observer>();
	}
	
	public void registerObserver(Observer o) {
		observers.add(o);		//注册的观察者直接添加在后面即可

	}


	public void removeObserver(Observer o) {
		int i = observers.indexOf(o);		//找到索引并删除
		if(i >= 0) {
			observers.remove(i);
		}
	}


	public void notifyOvbserver() {
		for(int i = 0; i < observers.size(); i++) {				//循环取出观察者并且逐一通知
			Observer observer = (Observer)observers.get(i);
			observer.update(temperature, humidity, pressure);
		}
	}
	
	public void measurementChanged() {
		notifyOvbserver();
	}
	
	public void setMeasurements(float temperature, float humidity, float pressure) {
		this.temperature = temperature;
		this.humidity = humidity;
		this.pressure = pressure;
		measurementChanged();
	}
}
