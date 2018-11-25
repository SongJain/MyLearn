
public interface Observer {
	public void update(float temp, float humidity, float pressure);		//当天气观测值发生改变时
																		//主题会把状态传给观察者
}
